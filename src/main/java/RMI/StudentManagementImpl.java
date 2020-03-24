package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagementImpl extends UnicastRemoteObject implements StudentManagement {
    Map<Integer, Student> integerStudentMap = new HashMap<>();

    StudentManagementImpl() throws RemoteException {
        super();
    }

    public void addNewStudent(Student student) {
        integerStudentMap.put(student.getStudentId(), student);
    }

    public void addNewStudents(List<Student> students) {
        for (Student student : students) {
            addNewStudent(student);
        }
    }

    @Override
    public String getStudentInfo(Integer studentId) throws RemoteException {
        if (!integerStudentMap.containsKey(studentId)) {
            return "Not found!";
        } else {
            return integerStudentMap.get(studentId).toString();
        }
    }

    static class Student {
        private Integer studentId;
        private String className;
        private String fullName;
        private String phoneNumber;
        private String address;

        public Student(int studentId, String className, String fullName, String phoneNumber, String address) {
            this.studentId = studentId;
            this.className = className;
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public Integer getStudentId() {
            return studentId;
        }

        @Override
        public String toString() {
            return "Student Info: \n" +
                    "StudentID: " + studentId.toString() + "\n" +
                    "Full name: " + fullName + "\n" +
                    "Class name: " + className + "\n" +
                    "Phone number: " + phoneNumber + "\n" +
                    "Address: " + address + "\n";
        }
    }
}
