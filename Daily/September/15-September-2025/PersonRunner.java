
import java.util.Scanner;

class PersonRunner {
    public static void main(String[] args) {
        Data data = new Person();
        Person person=new Person();
        Game game = new Game();
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        data.SchoolData();
        person.CollegeData();
        person.EmploymentData();
    }
}
interface  Data {
    abstract void SchoolData();
    abstract void CollegeData();
    abstract void EmploymentData();
}
// class Person extends Data{
class Person implements Data{
    public void SchoolData() {
        // System.out.println("Enter your name: ");
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.next();
        System.out.println("Enter your school name: ");
        Scanner scanner = new Scanner(System.in);
        String SchoolName = scanner.next();
        System.out.println("Enter your 10th percentage: ");
        Scanner scanner1 = new Scanner(System.in);
        Float percentage = scanner1.nextFloat();     
        // super.SchoolData();   
    }
    public void CollegeData() {
        // System.out.println("Enter your name: ");
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.next();
        System.out.println("Enter your college name: ");
        Scanner scanner = new Scanner(System.in);
        String SchoolName = scanner.next();
        System.out.println("Enter your 12th/Diploma percentage: ");
        Scanner scanner1 = new Scanner(System.in);
        Float percentage = scanner1.nextFloat(); 
        // super.CollegeData();
    }
    public void EmploymentData() {
        // System.out.println("Enter your name: ");
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.next();
        System.out.println("Enter your company name: ");
        Scanner scanner = new Scanner(System.in);
        String SchoolName = scanner.next();
        System.out.println("Enter your position: ");
        Scanner scanner1 = new Scanner(System.in);
        String position = scanner1.next();
        // super.EmploymentData();
    }
}
class Game implements Data {
    public void SchoolData() {
        // System.out.println("Enter your name: ");
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.next();
        System.out.println("Enter your school name: ");
        Scanner scanner = new Scanner(System.in);
        String SchoolName = scanner.next();
        System.out.println("Enter your 10th percentage: ");
        Scanner scanner1 = new Scanner(System.in);
        Float percentage = scanner1.nextFloat();     
        // super.SchoolData();   
    }
    public void CollegeData() {
        // System.out.println("Enter your name: ");
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.next();
        System.out.println("Enter your college name: ");
        Scanner scanner = new Scanner(System.in);
        String SchoolName = scanner.next();
        System.out.println("Enter your 12th/Diploma percentage: ");
        Scanner scanner1 = new Scanner(System.in);
        Float percentage = scanner1.nextFloat(); 
        // super.CollegeData();
    }
    // public void EmploymentData() {
    //     // System.out.println("Enter your name: ");
    //     // Scanner scanner = new Scanner(System.in);
    //     // String name = scanner.next();
    //     System.out.println("Enter your company name: ");
    //     Scanner scanner = new Scanner(System.in);
    //     String SchoolName = scanner.next();
    //     System.out.println("Enter your position: ");
    //     Scanner scanner1 = new Scanner(System.in);
    //     String position = scanner1.next();
    //     // super.EmploymentData();
    // }
}