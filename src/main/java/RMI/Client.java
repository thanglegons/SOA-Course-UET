package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            StudentManagement studentManagement = (StudentManagement)
                    Naming.lookup("rmi://localhost:1919" + "/find_student");
            Scanner inputFromCommandLine = new Scanner(System.in);
            while (true) {
                System.out.println("Input student id or \"Terminate\" to end program");
                String input = inputFromCommandLine.nextLine();
                if (input.equals("Terminate")) {
                    break;
                }
                Integer studentId = Integer.parseInt(input);
                String responseFromSever = studentManagement.getStudentInfo(studentId);
                System.out.println(responseFromSever);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
