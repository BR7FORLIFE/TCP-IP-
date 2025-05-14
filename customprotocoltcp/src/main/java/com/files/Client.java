package com.files;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void connect() {
        String host = "localhost";
        int port = 8080;

        try (Socket clientTCP = new Socket(host, port);
                BufferedReader readRequest = new BufferedReader(new InputStreamReader(clientTCP.getInputStream()));
                PrintWriter sendRequest = new PrintWriter(clientTCP.getOutputStream(), true);
                Scanner entrada = new Scanner(System.in);) {
                
            System.out.println(">");
            String command = entrada.nextLine();
            sendRequest.println(command);
            
            String line;
            while ((line = readRequest.readLine()) != null) {
                if (line.isEmpty()) {
                    // Fin de los headers, ahora viene el cuerpo
                    break;
                }
                // Puedes ignorar los headers o imprimirlos
                System.out.println("Header: " + line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
