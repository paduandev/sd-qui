import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socketClient;
        final int PORT = 12345;
        Scanner input;
        PrintStream output;
        HashMap<String, String> dictionary = new HashMap<>();

        dictionary.put("red", "vermelho");
        dictionary.put("green", "verde");
        dictionary.put("black", "preto");
        dictionary.put("white", "branco");

        // criar o ServerSocket e fazer o bind
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Bind success!");
        } catch (Exception e) {
            System.out.println("Erro: Porta em uso");
            return;
        }

        // aguardar pedido de conexão
        try {
            System.out.println("Esperando um cliente...");
            socketClient = serverSocket.accept();
            input = new Scanner(socketClient.getInputStream());
            output = new PrintStream(socketClient.getOutputStream());
            System.out.println("Conectado com " + socketClient.getInetAddress());
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o cliente");
            return;
        }

        // etapa de comunicação
        try {
            String msg;
            do {
                msg = input.nextLine();
                System.out.println("Recebido: " + msg);
                output.println(dictionary.get(msg));
            } while (!msg.equals("exit"));
        } catch (Exception e) {
            System.out.println("Erro ao receber os dados");
        }

        // encerrar a conexão
        try {
            socketClient.close();
            serverSocket.close();
        } catch (Exception e) {

        }
    }
}