package com.files;

public class Main {
    public static void main(String[] args) {
        new Thread(Server::response).start();

        // Espera medio segundo para que el servidor arranque antes de conectar
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        Client.connect();
    }
}