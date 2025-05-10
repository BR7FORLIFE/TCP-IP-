package com.archives.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    private static final int port = 8080;

    public static void startServer() {
        try (ServerSocket serverTCPIP = new ServerSocket(port)) {

            while (true) {
                Socket client = serverTCPIP.accept();
                new Thread(() -> processRequest(client)).start(); // <-- creamos un nuevo hilo por cada cliente
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void processRequest(Socket client) {
        try (BufferedReader readRequest = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter serverResponse = new PrintWriter(client.getOutputStream(), true);) {

            String line;
            int result = 0;

            while ((line = readRequest.readLine()) != null) {
                try {
                    result = doOperation(Integer.parseInt(line));

                } catch (NumberFormatException e) {
                   System.out.println(e);
                }
            }
            // enviamos la respuesta http
            serverResponse.println("El mensaje del servidor es que el numero multiplicado por 2 es: " + result);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int doOperation(int operation) {
        return operation * 2;
    }
}
