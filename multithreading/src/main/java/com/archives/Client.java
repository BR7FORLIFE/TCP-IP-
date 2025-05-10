package com.archives;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void sendRequest() {
        int port = 8080;
        String host = "localhost";

        try (Socket socket = new Socket(host, port);
                Scanner entrada = new Scanner(System.in);
                PrintWriter sendMessage = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Mensaje para enviar al servidor: ");
            String prompt = entrada.nextLine();
            sendMessage.println(prompt);

            // Leer respuesta del servidor
            String responseLine;
            while ((responseLine = responseReader.readLine()) != null) {
                System.out.println("Respuesta del servidor: " + responseLine);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }   
}
