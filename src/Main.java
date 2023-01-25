import java.util.HashMap;
import java.util.Scanner;

class Student {
    HashMap<Integer, String> studentHasMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    void addStudent() {
        studentHasMap.put(101, "Student1");
        studentHasMap.put(102, "Student2");
    }

    void regStudent() {
        System.out.println("Student, enter Your Name: ");
        String inStudentName = scanner.nextLine();
        System.out.println("Student, enter Your ID: ");
        int inStudentID = scanner.nextInt();
        studentHasMap.put(inStudentID, inStudentName);
        System.out.println("You are now registered!" + "\n");
        addStudent();
        System.out.println("Our members are: " + "\n" + studentHasMap);
    }
}



class Book {

}



class Issue {

}



public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.regStudent();

    }
}