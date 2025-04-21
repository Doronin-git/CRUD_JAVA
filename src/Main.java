import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int printmenu(){
        System.out.println("===== Student Manager =====");
        System.out.println("1. Add student");
        System.out.println("2. List all students");
        System.out.println("3. Edit student");
        System.out.println("4. Remove student");
        System.out.println("5. Find student");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        return  option;
    }

    public static void main(String[] args) {
        // creating list
        List<Student> studentList = new ArrayList<>();
        int option;

        do{
            option = printmenu();

            switch (option) {
                case 1:
                    StudentFunctions.addStudent(studentList);
                    break;
                case 2:
                    StudentFunctions.listAllStudents(studentList);
                    break;
                case 3:
                    StudentFunctions.editStudent(studentList);
                    break;
                case 4:
                    StudentFunctions.removeStudent(studentList);
                    break;
                case 5:
                    StudentFunctions.findStudent(studentList);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }while (true);
    }
}