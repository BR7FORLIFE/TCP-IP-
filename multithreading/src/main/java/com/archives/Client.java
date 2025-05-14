package com.archives;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void sendRequets() {
        int port = 8080;
        String host = "localhost";

        try (Socket userTCPIP = new Socket(host, port);
                Scanner entrada = new Scanner(System.in)) {

            System.out.println("Mensaje para enviar al servidor: ");
            String prompt = entrada.nextLine();

            OutputStream encode = userTCPIP.getOutputStream();
            PrintWriter sendMessage = new PrintWriter(encode, true);
            sendMessage.print(prompt);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
