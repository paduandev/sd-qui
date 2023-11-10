package chat.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import chat.util.Message;

public class Attendance extends Thread {
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public Attendance(Socket clientSocket) {
        try {
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void sendMessage(Message message) {
        try {
            out.writeObject(message);
        } catch (Exception e) {
            System.out.println("Erro on send message: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = (Message) in.readObject();
                for (Attendance attendance: Server.listThreads) {
                    attendance.sendMessage(message);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            Server.listThreads.remove(this);
        }
    }
}
