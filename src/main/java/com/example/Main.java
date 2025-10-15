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
        do {
            Socket Mysocket = MyServerSocket.accept();
            MyThread t = new MyThread(Mysocket);
            t.start();
        } while (true);
    }
}