import java.io.IOException;
import java.util.Scanner;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Servidor {
    public static void main(String[] args) throws IOException, Exception {
        
        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(5000);
        
        System.out.println("Servidor iniciado.");

        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        System.out.println("Cliente conectado.");

        Scanner scanner = new Scanner(clientSocket.getInputStream());
        while (true) {
            String message = scanner.nextLine();
            System.out.println("Mensagem recebida: " + message);
        }
    }
}