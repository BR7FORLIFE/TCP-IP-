package com.archives;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void start() {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor esperando conexión en el puerto " + port);

            while (true) {
                Socket client = serverSocket.accept(); //<- cliente de manera implicita
                System.out.println("Cliente conectado desde: " + client.getInetAddress());

                // Manejamos la conexión en un hilo separado para permitir múltiples clientes
                new Thread(() -> handleClient(client)).start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static void handleClient(Socket client) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
            String line;
            System.out.println("Leyendo la petición del cliente...");
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                System.out.println(line);
            }

            // Enviar respuesta HTTP bien formada
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/plain");
            writer.println("Content-Length: 5");
            writer.println(); // Línea vacía para terminar los headers
            writer.println("Hello");

        } catch (IOException e) {
            System.out.println("Error manejando cliente: " + e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                System.out.println("Error cerrando el socket: " + e.getMessage());
            }
        }
    }
}
