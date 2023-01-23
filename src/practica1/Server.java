package practica1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public abstract class Server {
    private ServerSocket serverSocket;
    private int port;

    public Server(int port) throws IOException {
        this.port = port;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(23);
        System.out.println("waiting..");
        Socket socket1 = serverSocket.accept();
        System.out.println("connected.");

        System.out.println("waiting..");
        Socket socket2 = serverSocket.accept();
        System.out.println("connected.");

        process(socket1, socket2);
    }

    public void start2() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("waiting..");
        Socket socket1 = serverSocket.accept();
        System.out.println("connected.");

        process(socket1);
    }

    public String send(Socket socket, String msj) throws IOException {
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println(msj);
        return msj;
    }
    public String recv(Socket socket) throws IOException {
        Scanner in = new Scanner(socket.getInputStream());
        return in.nextLine();
    }
    public abstract void process(Socket socket1, Socket socket2) throws IOException;

    public abstract void process(Socket socket) throws IOException;

}
