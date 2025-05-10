package com.archives;

public class Main {
    public static void main(String[] args) {
        // Iniciar el servidor en un hilo separado
        new Thread(() -> Server.start()).start();

        // Esperamos un poco para que el servidor arranque antes de lanzar el cliente
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // Iniciar el cliente
        Client client = new Client();
        client.sendRequest();
    }
}
