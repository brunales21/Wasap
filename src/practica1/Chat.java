package practica1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat extends Server {
    private List<Client> members = new ArrayList<>();

    public Chat() throws IOException {
        super(23);

    }

    public void addMember(Client client) {
        members.add(client);
    }

    @Override
    public void process(Socket socket1, Socket socket2) throws IOException {
        Scanner in = new Scanner(socket1.getInputStream());
        PrintStream out = new PrintStream(socket1.getOutputStream());

        Scanner in2 = new Scanner(socket2.getInputStream());
        PrintStream out2 = new PrintStream(socket2.getOutputStream());

        do {
                out2.println(in.nextLine());
                out.println(in2.nextLine());

            /*
            String msj = recv(socket1);
            send(socket2, msj);
            String msj2 = recv(socket2);
            send(socket1, msj2);

             */
        } while (true);
    }

    @Override
    public void process(Socket socket) throws IOException {

    }

    public static void main(String[] args) throws IOException {
        Chat chat = new Chat();
        chat.start();
    }
}
