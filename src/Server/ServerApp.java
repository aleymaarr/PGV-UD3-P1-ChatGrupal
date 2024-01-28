package Server;

import common.Constants;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    public static void main(String[] args) {
        ExecutorService clientPool = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(Constants.SERVER_PORT)) {
            System.out.println("Chat Server está escuchando en el puerto " + Constants.SERVER_PORT);

            while (true) {
                var clientSocket = serverSocket.accept();
                clientPool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
