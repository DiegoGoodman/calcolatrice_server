package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread extends Thread {
    private Socket mySocket;

    public MyThread(Socket mySocket) {
        this.mySocket = mySocket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);

            out.println("BuonomoServer 1.2");
            String risultato = in.readLine();
            System.out.println(risultato);

            String operazione;
            do {
                Double n1 = Double.parseDouble(in.readLine());
                Double n2 = Double.parseDouble(in.readLine());
                operazione = in.readLine();
                System.out.println(operazione);

                if (operazione.equals("1")) {
                    out.println(n1 + n2);
                } else if (operazione.equals("2")) {
                    out.println(n1 - n2);
                } else if (operazione.equals("3")) {
                    if (n2 == 0)
                        out.println("Errore: impossibile dividere per zero.");
                    else
                        out.println(n1 / n2);
                } else if (operazione.equals("4")) {
                    out.println(n1 * n2);
                } else if (operazione.equals("0")) {
                    out.println("!");
                } else {
                    out.println("Errore -> numero di operazione non valido.");
                }
            } while (!operazione.equals("0"));
        } catch (IOException e) {
        }
    }
}
