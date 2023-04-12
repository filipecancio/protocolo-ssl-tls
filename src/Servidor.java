import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.Scanner;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class Servidor {
    public static void main(String[] args) throws IOException, Exception {

        char[] passphrase = "senha senha".toCharArray();

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("keystore.jks"), passphrase);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");

        kmf.init(ks, passphrase);
        tmf.init(ks);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        
        SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(5050);
        
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