import java.util.HashMap;
import java.util.Map;
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
        System.out.println("Student, enter Your ID: " + studentHasMap);
        int inStudentID = scanner.nextInt();
        studentHasMap.put(inStudentID, inStudentName);
        System.out.println("You are now registered!" + "\n");
        addStudent();
        System.out.println("Our members now are: " + "\n" + studentHasMap);
    }
}


class Book {
    HashMap<Integer, String> bookHashMap = new HashMap<>();

    void addBook() {
        bookHashMap.put(11, "Book1");
        bookHashMap.put(12, "Book2");
    }
}


class Issue {
    HashMap<Integer, String> issueHashMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    Student studentObj = new Student();
    Book bookObj = new Book();

    Issue() {
        studentObj.addStudent();
        bookObj.addBook();
    }

    void issueBook(int studentID) {
        if (studentObj.studentHasMap.containsKey(studentID)) {
            System.out.println("Enter a issued book name: " + bookObj.bookHashMap);
            String issuedBookName = scanner.nextLine();
            int bookID = 0;

            if (bookObj.bookHashMap.containsValue(issuedBookName)) {
                for (Map.Entry<Integer, String> entryIssue : bookObj.bookHashMap.entrySet()) {
                    if (entryIssue.getValue().equals(issuedBookName)) {
                        bookID = entryIssue.getKey();
                        break;
                    }
                }

                bookObj.bookHashMap.remove(bookID);
                    System.out.println("Book is removed from bookHashMap");
                issueHashMap.put(studentID, issuedBookName);
                    System.out.println("Book is added to issueHashMap" + "\n");

                String studentName = studentObj.studentHasMap.get(studentID);
                System.out.println("Name: " + studentName);
                System.out.println("Book: " + issuedBookName);
                System.out.println("Book is issued!");
            } else {
                System.out.println("We have not such a book in library!");
                System.out.println("We have following books..." + "\n" + bookObj.bookHashMap);
            }

        } else {
            System.out.println("...to issue, before, please reg yourself" + "\n");
            studentObj.regStudent();
        }
        scanner.close();
    }

    void returnBook() {

    }

    void getPurpose() {

    }

}


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your ID (101, 102, ...): ");
        int studentID = scanner.nextInt();

        Issue issuedObj = new Issue();
        issuedObj.issueBook(studentID);

    }
}