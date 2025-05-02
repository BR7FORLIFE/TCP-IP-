package com.servesockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void sendRequest() throws IOException {
        // Abrir un ServerSocket en el puerto 8080.
        try (ServerSocket openTCP = new ServerSocket(8080)) {
            System.out.println("Esperando la conexión del cliente...");

            // Aceptar una conexión entrante de un cliente.
            Socket clientSocket = openTCP.accept();

            // Leer la petición enviada por el cliente.
            InputStream decodeRequest = clientSocket.getInputStream();
            InputStreamReader encodedRequest = new InputStreamReader(decodeRequest);
            BufferedReader readRequest = new BufferedReader(encodedRequest);

            // Leer línea por línea del cliente.
            String line;
            while ((line = readRequest.readLine()) != null) {
                System.out.println("Petición recibida del cliente: " + line);
            }

            // Enviar respuesta al cliente.
            String responseMessage = "Se ha recibido la petición!";
            OutputStream resToClient = clientSocket.getOutputStream();
            PrintWriter sendResponse = new PrintWriter(resToClient, true);

            sendResponse.println(responseMessage);  // Enviar la respuesta al cliente.

            // Cerrar el socket del cliente después de responder.
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        sendRequest();  // Ejecutar el servidor para que espere la conexión del cliente.
    }
}
