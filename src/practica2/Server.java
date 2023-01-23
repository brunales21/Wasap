package practica2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private int port;


    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);

        System.out.println("waiting");
        Socket socket = serverSocket.accept();
        System.out.println("accepted");

        process(socket);

    }

    public void process(Socket socket) throws IOException {
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println();
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server(23);
        s.start();
    }
}


