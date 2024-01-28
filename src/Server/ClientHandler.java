package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ClientHandler {

    private static final Set<ClientHandler> clients = new HashSet<>();
    private final Socket socket;
    private DataOutputStream outputStream;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            clientName = inputStream.readUTF(); // Read client's name
            sendToAll(clientName + " has joined the chat.");

            String message;
            while ((message = inputStream.readUTF()) != null) {
                if ("bye".equalsIgnoreCase(message)) {
                    clients.remove(this);
                    sendToAll(clientName + " has left the chat.");
                    break;
                }
                sendToAll("[" + clientName + "]: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendToAll(String message) {
        for (ClientHandler client : clients) {
            try {
                client.outputStream.writeUTF(message);
                client.outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
