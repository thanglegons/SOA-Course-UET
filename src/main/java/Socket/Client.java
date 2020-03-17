package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client(String address, int port) {
        try {
            Socket socket = new Socket(address, port);
            System.out.println("Connected to server!");

            Scanner inputFromCommandLine = new Scanner(System.in);
            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String input;

            while (true) {
                System.out.println("Input student id or \"Terminate\" to end program");
                input = inputFromCommandLine.nextLine();
                outputStream.writeUTF(input);
                if (input.equals("Terminate")) {
                    break;
                }
                String responseFromSever = inputFromServer.readUTF();
                System.out.println(responseFromSever);
            }

            inputFromCommandLine.close();
            outputStream.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("Cannot connect to sever");
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1", 1910);
    }

}