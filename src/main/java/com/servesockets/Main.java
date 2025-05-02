package com.servesockets;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Crear una nueva instancia de cliente y ejecutar la solicitud
        Client.doRequest(); // Cliente se conecta y envía un mensaje

        // Iniciar el servidor en un hilo para esperar la conexión
        Thread serverThread = new Thread(() -> {
            try {
                Server.sendRequest(); // El servidor escucha y responde
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Iniciar el servidor en paralelo
        serverThread.start();
    }
}
