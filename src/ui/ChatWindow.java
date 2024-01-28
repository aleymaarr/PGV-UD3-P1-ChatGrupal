package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

public class ChatWindow extends JFrame {
    private final JTextArea chatArea = new JTextArea();
    private final JTextField inputField = new JTextField();
    private final DataOutputStream outputStream;

    public ChatWindow(DataOutputStream outputStream) {
        this.outputStream = outputStream;
        setTitle("Chat Application");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                try {
                    outputStream.writeUTF(text);
                    outputStream.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                inputField.setText("");
            }
        });
        add(inputField, BorderLayout.SOUTH);
    }

    public void displayMessage(String message) {
        chatArea.append(message + "\n");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var chatWindow = new ChatWindow(null);
            chatWindow.setVisible(true);
        });
    }
}
