import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class StudentRunner {
    public static void main(String[] args) {
        // BirthDate birthDate = new BirthDate(12,11,2002);
        // System.out.println(birthDate.getDay() +"-"+birthDate.getMonth() +"-"+birthDate.getYear());
        // System.out.println(birthDate.getBirthMonth());
        // Bmi bmi = new Bmi(54.5, 1.70);
        // System.out.println(bmi.getBmi());
        Subjects subjects = new Subjects("Maths", "English", "History", "Computer", "Science");
        Student student = new Student("Alam", 22, "Indian", 12,11,2002 , 54.5, 1.70 ,10 , 98,97,90,87,80);
        // Student student1 = new Student("Abrar", "987654211", 29, "Indian", 3,2,1996, 65, 1.82);
        System.out.println(student);
        System.out.println(subjects);
    }
}
public class Student {
    String name;
    int age;
    String nationality;
    BirthDate birthDate;
    double weight;
    double height;
    Bmi bmi;
    int standard;
    private ArrayList<Integer> marks = new ArrayList<Integer>();
    
    public Student(String name, int age, String nationality, int day , int month, int year, double weight, double height, int standard , int... marks ) {
        this.name = name;
        for(int mark:marks) {
            this.marks.add(mark);
        }
        this.age= age;
        this.nationality = nationality;
        this.birthDate = new BirthDate(day , month, year);
        this.weight = weight;
        this.height = height;
        this.bmi = new Bmi(weight, height);
        this.standard= standard;
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
    public int getMaximumMarks() {
        return Collections.max(marks);
    }
    public int getMinimumMarks() {
        return Collections.min(marks);
    }
    public int getNumberOfMarks() {
        return marks.size();
    }
    public BigDecimal getAverageMarks() {
        int sum= getTotalSumOfMarks();
        int number= getNumberOfMarks();
        return new BigDecimal(sum).divide(new BigDecimal(number), 2, RoundingMode.HALF_UP);
    }
     public int getTotalSumOfMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }
    public String toString() {
        StringBuilder ps = new StringBuilder();
        ps.append("My name is ").append(name).append("\n").append("My Nationality is ").append(nationality).append("\n").append("My age is ").append(age).append("\n").append(birthDate).append("\n").append("My weight is ").append(weight).append("kg").append("\n").append("My height in metres is ").append(height).append("\n").append("My BMI is ").append(bmi).append("\n").append("I am in standard ").append(standard).append("\n").append("My marks are ").append(marks).append("\n").append("My maximum marks are ").append(this.getMaximumMarks()).append("\n").append("My minimum marks are ").append(this.getMinimumMarks()).append("\n").append("My average marks are ").append(this.getAverageMarks());
        return ps.toString();
    }
}
public class Subjects {
    List<String> subjects;

    public Subjects(String... subjects) {
        this.subjects = new ArrayList<>();
        for (String subject : subjects) {
            this.subjects.add(subject);
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("My subjects are ").append(subjects);
        return sb.toString();
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

