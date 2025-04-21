public class Student {
    // поля
    static int counter = 0;

    int id,age;
    String firstname;
    String lastname;
    String dni;
    // konstruct

    public  Student(String dni,String firstname, String lastname, int age){
        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.age = age;
        this.id = counter++;
    }
}
