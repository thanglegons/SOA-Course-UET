package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentManagement extends Remote {
    String getStudentInfo(Integer studentId) throws RemoteException;
}
