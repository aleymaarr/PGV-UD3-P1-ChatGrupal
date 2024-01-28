package client;

import common.Constants;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", Constants.SERVER_PORT);
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor de chat");
            new ListenerThread(inputStream).start();

            System.out.println("Escriba sus mensajes a continuación:");

            while (true) {
                String messageToSend = scanner.nextLine();
                outputStream.writeUTF(messageToSend);
                outputStream.flush();
                if ("bye".equalsIgnoreCase(messageToSend)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
