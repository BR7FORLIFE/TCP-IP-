package com.archives.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {
    private static final int port = 8080;
    private static final String host = "localhost";

    public static void sendRequest() { // <-- preparamos el socket, los Streams y los buffer
        try (Socket clientTCPIP = new Socket(host, port);
                Scanner entrada = new Scanner(System.in);
                PrintWriter sendMessage = new PrintWriter(clientTCPIP.getOutputStream(), true);
                BufferedReader readResponse = new BufferedReader(new InputStreamReader(clientTCPIP.getInputStream()))

        ) { // <- preparamos para enviar un mensaje al servidor
            System.out.println("Digite la operacion matematica para evaluar en el servidor: ");
            int message = entrada.nextInt();
            sendMessage.print(message);

            // <-- preparamos para la respuesta del servidor
            String line;
            while ((line = readResponse.readLine()) != null) {
                System.out.println("Respuesta por parte del servidor: " + line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
