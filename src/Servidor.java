import com.sun.net.httpserver.*;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Scanner;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class Servidor {
    public static void main(String[] args) throws IOException, Exception {

        char[] passphrase = "senha senha".toCharArray();
    
        // carrega o arquivo de keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("keystore.jks"), passphrase);

        // inicializa o gerenciador de chaves
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, passphrase);

        // inicializa o gerenciador de confiança
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ks);

        // cria um contexto SSL
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory(); //(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);
        
        System.out.println("Servidor iniciado com SSL.");

        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        System.out.println("Cliente conectado.");

        while(true){


        Scanner scanner = new Scanner(clientSocket.getInputStream());
        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        }
}
}