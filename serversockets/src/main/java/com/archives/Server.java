package com.archives;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void proccessRequest() {
        try (ServerSocket openTCP = new ServerSocket(8080)) {
            System.out.println("Servidor esperando conexión del cliente...");

            // Aceptar la conexión del cliente
            Socket clientSocket = openTCP.accept();
            System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress());

            // Leer la petición que envía el cliente
            InputStream decodeRequest = clientSocket.getInputStream();
            InputStreamReader encodedRequest = new InputStreamReader(decodeRequest);
            BufferedReader readRequest = new BufferedReader(encodedRequest);

            String line;
            while ((line = readRequest.readLine()) != null) {
                System.out.println("Petición recibida del cliente: " + line);
            }

            // Enviar respuesta al cliente
            String response = "¡Petición recibida correctamente!";
            OutputStream resToClient = clientSocket.getOutputStream();
            PrintWriter sendResponse = new PrintWriter(resToClient, true);
            sendResponse.println(response);

            // Cerrar conexiones específicas (el ServerSocket se cierra automáticamente por
            // try-with-resources)
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

}
