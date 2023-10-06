import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Socket socket;
        final int PORT = 12345;
        final String IP = "127.0.0.1"; // localhost
        PrintStream output;
        Scanner input;

        // criar o socket e solicitar a coenxão
        try {
            socket = new Socket(IP, PORT);
            output = new PrintStream(socket.getOutputStream());
            input = new Scanner(socket.getInputStream());
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro na conexão");
            return;
        }

        // etapa de comunicação
        try {
            Scanner teclado = new Scanner(System.in);
            String msg, tranlate;
            do {
                System.out.println("Digite a palavra:");
                msg = teclado.nextLine();
                output.println(msg);
                tranlate = input.nextLine();
                System.out.println("Tradução: " + tranlate);
            } while(!msg.equals("exit"));
        } catch (Exception e) {
            System.out.println("Erro ao enviar os dados");
        }

        // encerrar a conexão
        try {
            socket.close();
        } catch (Exception e) {
            
        }
    }
}