
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
        person.JuniorCollegeData();
        person.EmploymentData();
    }
}
interface  Data {
    abstract void SchoolData();
    abstract void JuniorCollegeData();
    abstract void SeniorCollegeData();
    abstract void EmploymentData();
}
// class Person extends Data{
class Person implements Data{
    public void SchoolData() {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter your school name: ");
        String schoolName = scanner.next();
        System.out.print("Enter your 10th percentage: ");
        float percentage = scanner.nextFloat();
        System.out.println("School: " + schoolName + "\n 10th %: " + percentage);    
    }
    public void JuniorCollegeData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your junior college name: ");
        String collegeName = scanner.next();
        System.out.print("Enter your 12th/Diploma percentage: ");
        float percentage = scanner.nextFloat();
        System.out.println("College: " + collegeName + "\n 12th/Diploma %: " + percentage); 
    }
    public void SeniorCollegeData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your senior college name: ");
        String collegeName = scanner.next();
        System.out.print("Enter your Graduation percentage: ");
        float percentage = scanner.nextFloat();
        System.out.println("College: " + collegeName + "\n Graduation %: " + percentage); 
    }
    public void EmploymentData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your company name: ");
        String companyName = scanner.next();
        System.out.print("Enter your position: ");
        String position = scanner.next();
        System.out.println("Company: " + companyName + "\n Position: " + position);
    }
}
class Game implements Data {
    public void printName() {
        System.out.println("Name");
    }
    public void SchoolData() {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter your school name: ");
        String schoolName = scanner.next();
        System.out.print("Enter your 10th percentage: ");
        float percentage = scanner.nextFloat();
        System.out.println("School: " + schoolName + "\n 10th %: " + percentage);    
    }
    public void JuniorCollegeData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your junior college name: ");
        String collegeName = scanner.next();
        System.out.print("Enter your 12th/Diploma percentage: ");
        float percentage = scanner.nextFloat();
        System.out.println("College: " + collegeName + "\n 12th/Diploma %: " + percentage); 
    }
    public void SeniorCollegeData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your senior college name: ");
        String collegeName = scanner.next();
        System.out.print("Enter your Graduation percentage: ");
        float percentage = scanner.nextFloat();
        System.out.println("College: " + collegeName + "\n Graduation %: " + percentage); 
    }
    public void EmploymentData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your company name: ");
        String companyName = scanner.next();
        System.out.print("Enter your position: ");
        String position = scanner.next();
        System.out.println("Company: " + companyName + "\n Position: " + position);
    }
}