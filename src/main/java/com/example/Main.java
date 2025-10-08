package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket MyServerSocket = new ServerSocket(3000);
        Socket Mysocket = MyServerSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(Mysocket.getInputStream()));
        PrintWriter out = new PrintWriter(Mysocket.getOutputStream(), true);

        out.println("BuonomoServer 1.2");
        String risultato = in.readLine();
        System.out.println(risultato);

        String operazione;
        do {
        int n1 = Integer.parseInt(in.readLine());
        int n2 = Integer.parseInt(in.readLine());
        operazione = in.readLine();
        System.out.println(operazione);

        if (operazione.equals("1")){
            out.println(n1 + n2);
        }
        else if (operazione.equals("2")){
            out.println(n1 - n2);
        }
        else if (operazione.equals("3")){
            if (n2 == 0)
                out.println("Errore: impossibile dividere per zero.");
            else
                out.println(n1 / n2);
        }
        else if (operazione.equals("4")){
            out.println(n1 * n2);
        }
        else if (operazione.equals("exit")){
            out.println("!");
        }
        else{
            out.println("Errore -> numero di operazione non valido.");
        }
        } while (!operazione.equals("exit"));   
        MyServerSocket.close();
    }
}