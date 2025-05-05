package com.archives;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void sendRequest() {
        try (Socket client = new Socket("localhost", 8080); Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escribe tu mensaje para el servidor: ");
            String message = scanner.nextLine();

            OutputStream sendInformation = client.getOutputStream();
            PrintWriter response = new PrintWriter(sendInformation, true);
            response.println(message);

            System.out.println("Mensaje enviado al servidor.");

        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
