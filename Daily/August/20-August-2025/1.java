import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class PersonRunner {
    public static void main(String[] args) {
        // BirthDate birthDate = new BirthDate(12,11,2002);
        // System.out.println(birthDate.getDay() +"-"+birthDate.getMonth() +"-"+birthDate.getYear());
        // System.out.println(birthDate.getBirthMonth());
        // Bmi bmi = new Bmi(54.5, 1.70);
        // System.out.println(bmi.getBmi());
        Person person = new Person("Alam", "9373807292", 22, "Indian", 12,11,2002 , 54.5, 1.70);
        Person person1 = new Person("Abrar", "987654211", 29, "Indian", 3,2,1996, 65, 1.82);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getBmi());
        System.out.println(person.getBirthMonth());
        System.out.println(person);
        System.out.println(person1);
    }
}
public class Person {
    String name;
    String mobileNumber;
    int age;
    String nationality;
    BirthDate birthDate;
    double weight;
    double height;
    Bmi bmi;
    
    public Person(String name, String mobileNumber, int age, String nationality,int day , int month, int year, double weight, double height) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.age= age;
        this.nationality = nationality;
        this.birthDate = new BirthDate(day , month, year);
        this.weight = weight;
        this.height = height;
        this.bmi = new Bmi(weight, height);
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public double getBmi() {
        return this.bmi.getBmi();
    }
    public String getBirthMonth() {
        return this.birthDate.getBirthMonth();
    }
    public String toString() {
        StringBuilder ps = new StringBuilder();
        ps.append("My name is ").append(name).append("\n").append("My Nationality is ").append(nationality).append("\n").append("My age is ").append(age).append("\n").append(birthDate).append("\n").append("My contact number is ").append(mobileNumber).append("\n").append("My weight is ").append(weight).append("kg").append("\n").append("My height in metres is ").append(height).append("\n").append("My BMI is ").append(bmi).append("\n");
        return ps.toString();
    }
}
public class BirthDate {
    int day;
    int month;
    int year;
    
    public BirthDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }
    public String getBirthMonth() {
        switch(month) {
            case 1 : return "January";
            case 2 : return "February";
            case 3 : return "March";
            case 4 : return "April";
            case 5 : return "May";
            case 6 : return "June";
            case 7 : return "July";
            case 8 : return "August";
            case 9 : return "September";
            case 10 : return "October";
            case 11 : return "November";
            case 12 : return "December";
        }
        return "Invalid_monthNumber";
    }
    public String toString() {
        StringBuilder bd = new StringBuilder();
        bd.append("My birthdate is ").append(day).append("-").append(month).append("-").append(year);
        return bd.toString();
    }
}
public class Bmi {
    double weight;
    double height;
    double bmi;
    Bmi(double weight, double height) {
        this.weight = weight;
        this.height = height; 
        this.bmi = this.getBmi();
    }
    public double getBmi() {
        double bmi = this.weight / (this.height*this.height);
        return bmi;
    }
    public String toString() {
        StringBuilder bm = new StringBuilder();
        bm.append(bmi);
        return bm.toString();
    }
}


