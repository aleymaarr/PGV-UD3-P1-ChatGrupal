package client;

import java.io.DataInputStream;
import java.io.IOException;

public class ListenerThread extends Thread {

    private DataInputStream inputStream;

    public ListenerThread(DataInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                String message = inputStream.readUTF();
                System.out.println(message);
            }
        } catch (IOException e) {
            System.out.println("Desconectada del servidor de chat.");
        }
    }

}
