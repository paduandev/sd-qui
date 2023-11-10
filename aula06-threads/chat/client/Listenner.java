package chat.client;

import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import chat.util.Message;

public class Listenner extends Thread {
    private ObjectInputStream in;
    private JTextArea txtHistorico;

    public Listenner(Socket socket, JTextArea txtHistorico) {
        this.txtHistorico = txtHistorico;
        try {
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("Erro Listenner: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = (Message) in.readObject();
                txtHistorico.append(message.getUsername() + "> " + message.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("Erro Listenner: " + e.getMessage());
            }
        }
    }
    
}
