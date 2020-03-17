package Socket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagement {
    Map<Integer, Student> integerStudentMap = new HashMap<>();

    public StudentManagement() {
        addDefault();
    }

    private void addNewStudent(Student student) {
        integerStudentMap.put(student.getStudentId(), student);
    }

    private void addNewStudents(List<Student> students) {
        for (Student student : students) {
            addNewStudent(student);
        }
    }

    private void addDefault() {
        Student student1 = new Student(1, "hogwarts", "Harry", "0192", "unknown");
        Student student2 = new Student(2, "hogwarts", "Draco", "0193", "unknown");
        Student student3 = new Student(3, "hogwarts", "Hermione", "0194", "unknown");
        Student student4 = new Student(4, "hogwarts", "Ron", "0195", "unknown");
        addNewStudents(List.of(student1, student2, student3, student4));
    }

    String getStudentInfo(Integer studentId) {
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
