package Socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Socket.Server started, waiting for client");

        Socket socket = server.accept();

        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        StudentManagement studentManagement = new StudentManagement();

        String input;

        while (true) {
            try {
                input = inputStream.readUTF();
                if (input.equals("Terminate")) {
                    break;
                }
                Integer studentId = Integer.parseInt(input);
                System.out.println(studentId);
                String studentInfo = studentManagement.getStudentInfo(studentId);
                outputStream.writeUTF(studentInfo);
            } catch (Exception e) {
                outputStream.writeUTF("Cannot parse integer");
                System.out.println("Cannot parse integer");
            }
        }

        System.out.println("Closing connection");

        socket.close();
        inputStream.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(1910);
    }
}