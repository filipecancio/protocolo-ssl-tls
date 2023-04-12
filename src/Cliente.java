import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.sun.org.apache.bcel.internal.generic.DDIV;

public class Cliente extends JFrame implements KeyListener {
    private final JTextArea textArea;
    private final PrintWriter out;

    public Cliente() throws IOException, Exception  {

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
        
        // Cria a fábrica de socket SSL
        SSLSocketFactory factory = sslContext.getSocketFactory(); //(SSLSocketFactory) SSLSocketFactory.getDefault();
        
        // Cria o socket SSL
        SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 5000);
        System.out.println("Conectado ao servidor.");

        // Define as opções de criptografia
        String[] cipherSuites = {"TLS_RSA_WITH_AES_128_CBC_SHA"};
        socket.setEnabledCipherSuites(cipherSuites);

        textArea = new JTextArea();
        textArea.addKeyListener(this);
        add(textArea);

        setMinimumSize(new Dimension(400, 300)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não utilizado
    }

    @Override
    public void keyPressed(KeyEvent e) {

            String message = textArea.getText();
            out.println(message + " letra enviada");
            
            textArea.setText("");
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Não utilizado
    }

    public static void main(String[] args) throws IOException, Exception  {
        new Cliente();
    }
}