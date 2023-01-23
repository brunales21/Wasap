import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
    }

    public void send() throws IOException {
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println(new Scanner(System.in).nextLine());
    }

    public void recv() throws IOException {
        Scanner in = new Scanner(socket.getInputStream());
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }

    }

    public void cleanConsole() {
        System.out.println("\033[2J");
        System.out.println( "\033[H");
    }


    public static void main(String[] args) throws IOException {
/*
        Client t1 = new Client("localhost", 23);
        t1.cleanConsole();
        t1.connect();
        t1.send();
        t1.recv();

 */


        Client c1 = new Client("localhost", 23);
        Client c2 = new Client("localhost", 23);
        c1.connect();
        c2.connect();
        System.out.println("\033[2J");
        System.out.println( "\033[H");
        do {
            c1.send();
            c2.recv();
            c2.send();
            c1.recv();
        } while (true);



    }


}
