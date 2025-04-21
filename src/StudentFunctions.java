import java.util.List;
import java.util.Scanner;


public class StudentFunctions {
    public static int searchStudent(List<Student> studentList, String Dni){
        for (int i = 0;i < studentList.size(); i++){
            if (studentList.get(i).dni.equals(Dni)){
                return i;
            }
        }
        return -1;
    }

    public static void addStudent(List<Student> studentList){
        Scanner scanner = new Scanner(System.in);
        String dni;

        while (true) {
            System.out.println("Enter the DNI number:");
            dni = scanner.next();
            scanner.nextLine();

            int pos = searchStudent(studentList, dni);
            if (pos != -1) {
                System.out.println("Student already exists!");
            } else {
                break;
            }
        }

        System.out.println("Enter the student firstname");
        String firstname = scanner.nextLine();

        System.out.println("Enter the student lastname");
        String lastname = scanner.nextLine();

        System.out.println("Enter the student age");
        int age = scanner.nextInt();

        Student new_student = new Student(dni,firstname,lastname,age);
        studentList.add(new_student);
    }

    public static void listAllStudents(List<Student> studentList){
        for (Student s : studentList){
            System.out.println(s.firstname + " " + s.lastname + " " + s.id);
        }
    }

    public static void editStudent(List<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        String dni;

        int pos;
        while (true) {
            System.out.println("Enter the DNI number:");
            dni = scanner.next();
            scanner.nextLine();

            pos = searchStudent(studentList, dni);
            if (pos == -1) {
                System.out.println("Student does not exist!");
            } else {
                break;
            }
        }

        Student student = studentList.get(pos);
        int option;

        while (true) {
            System.out.println("===== Edit Student =====");
            System.out.println("1. Edit first name");
            System.out.println("2. Edit last name");
            System.out.println("3. Edit age");
            System.out.println("4. Edit DNI");
            System.out.println("0. Cancel");
            System.out.print("Choose option: ");

            option = scanner.nextInt();
            scanner.nextLine(); // очищаем \n после nextInt()

            switch (option) {
                case 1:
                    System.out.print("Enter new first name: ");
                    student.firstname = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter new last name: ");
                    student.lastname = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Enter new age: ");
                    student.age = scanner.nextInt();
                    scanner.nextLine(); // очистка \n
                    break;
                case 4:
                    System.out.print("Enter new DNI: ");
                    student.dni = scanner.nextLine();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }

            System.out.println("Student updated successfully.\n");
        }
    }

    public static void removeStudent(List<Student> studentList){
        Scanner scanner = new Scanner(System.in);
        String dni;

        int pos;
        while (true) {
            System.out.println("Enter the DNI number:");
            dni = scanner.next();
            scanner.nextLine();

            pos = searchStudent(studentList, dni);
            if (pos == -1) {
                System.out.println("Student does not exist!");
            } else {
                break;
            }
        }

        studentList.remove(pos);
    }

    public static void findStudent(List<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        String dni;

        int pos;
        while (true) {
            System.out.println("Enter the DNI number:");
            dni = scanner.next();
            scanner.nextLine();

            pos = searchStudent(studentList, dni);
            if (pos == -1) {
                System.out.println("Student does not exist!");
            } else {
                break;
            }
        }

        Student s = studentList.get(pos);
        System.out.printf("ID: %d | DNI: %s | Name: %s %s | Age: %d%n",
                s.id, s.dni, s.firstname, s.lastname, s.age);
    }
}
