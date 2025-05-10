package com.archives.practice;

public class MainExample {
    public static void main(String[] args) {
        new Thread(() -> ServerExample.startServer()).start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        ClientExample.sendRequest();
    }
}
