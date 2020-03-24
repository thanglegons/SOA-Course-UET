package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try {
            StudentManagementImpl studentManagement = new StudentManagementImpl();
            addStudent(studentManagement);
            LocateRegistry.createRegistry(1919);
            Naming.rebind("rmi://localhost:1919" + "/find_student", studentManagement);
            System.out.println("Server starts successfully!");
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Server starts unsuccessfully :(");
            e.printStackTrace();
        }
    }

    private static void addStudent(StudentManagementImpl studentManagement) {
        StudentManagementImpl.Student student1 = new StudentManagementImpl.Student(1, "hogwarts", "Harry", "0192", "unknown");
        StudentManagementImpl.Student student2 = new StudentManagementImpl.Student(2, "hogwarts", "Draco", "0193", "unknown");
        StudentManagementImpl.Student student3 = new StudentManagementImpl.Student(3, "hogwarts", "Hermione", "0194", "unknown");
        StudentManagementImpl.Student student4 = new StudentManagementImpl.Student(4, "hogwarts", "Ron", "0195", "unknown");
        studentManagement.addNewStudents(List.of(student1, student2, student3, student4));
    }
}
