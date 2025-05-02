package com.servesockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void doRequest() throws IOException {
        try (Socket client = new Socket("localhost", 8080);
                Scanner entrada = new Scanner(System.in)) {

            // Solicitar al usuario que ingrese un mensaje.
            System.out.println("Ingresa el mensaje: ");
            String prompt = entrada.nextLine();

            // Obtener el OutputStream del socket.
            OutputStream sendInformation = client.getOutputStream();

            // Crear un PrintWriter para enviar datos de forma eficiente.
            PrintWriter response = new PrintWriter(sendInformation, true);
            response.println(prompt); // Enviar mensaje al servidor.

            // Recibir la respuesta del servidor.
            receiveResponse(client.getInputStream()); // Enviar InputStream para recibir la respuesta
        } catch (IOException e) {
            System.out.println("Error en la comunicación: " + e.getMessage());
        }
    }

    public static void receiveResponse(InputStream inputStream) throws IOException {
        // Leemos la respuesta del servidor.
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String response = bufferedReader.readLine(); // Leemos la respuesta.
        System.out.println("Respuesta del servidor: " + response);
    }

    public static void main(String[] args) throws IOException {
        doRequest(); // Llamar a la función para realizar la petición.
    }
}
