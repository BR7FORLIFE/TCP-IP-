package com.files;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void response() {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Conectandose al servidor...");

            while (true) {
                Socket client = server.accept();
                new Thread(() -> proccessRequest(client)).start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void proccessRequest(Socket client) {
        try (BufferedReader readRequest = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter sendRequest = new PrintWriter(client.getOutputStream(), true);) {
            String body;
            while ((body = readRequest.readLine()) != null) {
                System.out.println("Mensaje enviado por parte del usuario: " + body);
                String response = analizerCommand(body);
                String responseBody = "Respuesta: " + response;

                //System.out.println(response);
                sendRequest.println("HTTP/1.1 200 OK");
                sendRequest.println("Content-Type: text/plain");
                sendRequest.println("Content-Length: " + responseBody.length());
                sendRequest.println();
                sendRequest.println(responseBody);

            }
        } catch (Exception e) {
        }
    }

    private static String analizerCommand(String body) {
        if (body.startsWith("get")) {
            return "Solicitó una peticion de tipo get al servidor";
        }

        if (body.equals("help")) {
            return "Solicitó ayuda al servidor";
        }

        if (body.equals("Install")) {
            return "Usted solicito la instalacion";
        }

        return "404 Not Found Command";
    }
}
