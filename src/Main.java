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
    }

    void returnBook(int studentID) {
        issueHashMap.put(101, "Book1"); // for testing

        if (studentObj.studentHasMap.containsKey(studentID)) {
            if (issueHashMap.containsKey(studentID)) {
                System.out.println("Enter a return book name: " + bookObj.bookHashMap);
                String returnBookName = scanner.nextLine();
                int bookID = 0;

                for (Map.Entry<Integer, String> entryReturn : bookObj.bookHashMap.entrySet()) {
                    if (entryReturn.getValue().equals(returnBookName)) {
                        bookID = entryReturn.getKey();
                        break;
                    }
                }

                if (issueHashMap.containsValue(returnBookName)) {
                    issueHashMap.remove(studentID);
                        System.out.println("Book is removed from student issueHashMap");
                    bookObj.bookHashMap.put(bookID, returnBookName);
                        System.out.println("Book is placed back to bookHashMap" + "\n");

                    String studentName = studentObj.studentHasMap.get(studentID);
                    System.out.println("Name: " + studentName);
                    System.out.println("Book: " + returnBookName);
                    System.out.println("Book is returned!");
                } else {
                    System.out.println("Book is not issued...");
                }
            } else {
                System.out.println("You have not issued any book!");
            }

        } else {
            System.out.println("...must be registered and issued before" + "\n");
            studentObj.regStudent();
        }
    }

    void getPurpose(int studentID) {
        System.out.println("Enter Your purpose: \"issue\" or \"return\"");
        String purposeAnswer = scanner.next();

        Issue issueObj = new Issue();

        if (purposeAnswer.equals("issue")) {
            issueObj.issueBook(studentID);
        } else if (purposeAnswer.equals("return")) {
            issueObj.returnBook(studentID);
        }
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your ID (101, 102, ...): ");
        int studentID = scanner.nextInt();

        Student studentObj = new Student();
        studentObj.addStudent();
        Issue issueObj = new Issue();

        if (studentObj.studentHasMap.containsKey(studentID)) {
            issueObj.getPurpose(studentID);
        } else {
            System.out.println("Be a member? \"yes\" or \"no\"");
            String answer = scanner.next();

            if (answer.equals("yes")) {
                studentObj.regStudent();
                issueObj.getPurpose(studentID);
            } else {
                System.out.println("Bye then...!");
            }
        }
    }
}