package practica2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private String host;
    private int port;

    public Client(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);

    }

    public void recv() throws IOException {
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println(in.nextLine());
    }

    public static void main(String[] args) throws IOException {
        Client c = new Client("localhost", 23);
        c.connect();
        c.recv();
    }
}
