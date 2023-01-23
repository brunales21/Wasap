package practica1;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoFile extends Server {

    public EchoFile() throws IOException {
        super(23);
    }

    @Override
    public void process(Socket socket) throws IOException {
        Scanner in = new Scanner(socket.getInputStream());
        Scanner sc = new Scanner(new FileReader(in.nextLine()));
        PrintStream out = new PrintStream(socket.getOutputStream());
        while (sc.hasNextLine()) {
            out.println(sc.nextLine());
        }
    }

    @Override
    public void process(Socket socket1, Socket socket2) throws IOException {

    }


    public static void main(String[] args) throws IOException {
        EchoFile ef = new EchoFile();
        ef.start2();
    }
}
