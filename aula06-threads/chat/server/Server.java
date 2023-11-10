package chat.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    protected static final ArrayList<Attendance> listThreads = new ArrayList<>();

    public static void main(String[] args) {
        final int PORT = 9876;
        ServerSocket serverSocket;
        Socket clientSocket;

        try {
            serverSocket = new ServerSocket(PORT);

            while (true) { 
                System.out.println("Aguardando o próximo cliente...");
                clientSocket = serverSocket.accept();

                Attendance attendance = new Attendance(clientSocket);
                listThreads.add(attendance);
                attendance.start();
                System.out.println("Clientes conecatados: " + listThreads.size());
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
