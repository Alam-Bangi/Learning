import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class StudentRunner {
    public static void main(String[] args) {
        Student student= new Student("Alam", 12,11,2002,"Indian", 12, 54.5, 1.70);
        // System.out.println(student);
        student.assignSubjects();
        System.out.println(student);
    }
}
class Student {
    String name;
    String nationality;
    int standard;
    BirthDate birthDate;
    Bmi bmi;
    Subjects subjects;

    public Student(String name, int day, int month,int year , String nationality, int standard, double weight, double height) {
        this.name = name;
        this.nationality = nationality;
        this.standard = standard;
        this.bmi = new Bmi(weight,height); // height in meters
        this.birthDate = new BirthDate(day,month,year);
        this.subjects = new Subjects();
    }
    
    public void assignSubjects() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int inputFromUser = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        // System.out.println("--" +this.subjects);
        this.subjects = new Subjects(inputFromUser);
        for(int i = 0; i < inputFromUser; i++) {
            System.out.println("Enter subject " + (i + 1) + " name: ");
            String subjectName = scanner.nextLine();
            System.out.println("Enter marks for " + subjectName + ": ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            this.subjects.addSubject(subjectName, marks);
        }
    }
    
    public String getName() {
        return  name;
    }
    public double getBmi() {
        return this.bmi.getBmi();
    }
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("My name is ").append(name).append("\n").append(birthDate).append("\n").append("My nationality is ").append(nationality).append("\n")
        .append("My weight is ").append(this.bmi.getWeight()).append("\n").append("My height is ").append(this.bmi.getHeight()).append("\n").append(bmi).append("\n").append("I am in standard ").append(standard).append("\n")
        .append("Average Marks: ").append(this.subjects.getAverageMarks()).append("\n").append("Percentage: ").append(this.subjects.getPercentage()).append("\n").append("Subject Names: ")
        .append(Arrays.toString(this.subjects.getSubjectName())).append("\n").append("Total Marks: ").append(this.subjects.getTotalMarks()).append("\n");
        return st.toString();
    }
}
class BirthDate {
    private int day;
    private int month;
    private int year;

    public BirthDate(int day, int month, int year) {
        this.day=day;
        this.month= month;
        this.year=year;
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
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        int myAge = (currentDate.getYear()-1)-year;
        if (currentDate.getMonthValue()>=month || (currentDate.getDayOfMonth()>day && currentDate.getMonthValue()==month)) {
            myAge+=1;
        }
        return myAge;
    }
    public String toString() {
        StringBuilder bd = new StringBuilder();
        bd.append("My Birthdate is ").append(day).append("-").append(month).append("-").append(year).append("\n").append("My age is ").append(this.getAge());
        return bd.toString();
    }
}
class Bmi {
    private double weight;
    private double height;
    double bmi;

    Bmi(double weight, double height) {
        this.weight = weight;
        this.height = height;
        this.bmi = this.getBmi();
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public double getBmi() {
        double bmi = this.weight / (this.height*this.height);
        return bmi;
    }
    public String toString() {
        StringBuilder bm = new StringBuilder();
        bm.append("My bmi is ").append(bmi);
        return bm.toString();
    }
}
class Subject {
    String name;
    int marks;

    public Subject() {
        this.name = "Name";
        this.marks=0;
    }
    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public String toString() {
        return "Subject name = " +name + "marks = " +marks ;
    }
}
class Subjects {
    Subject[] subjects;
    int numSubjects = 0;
    int maxSubjects = 3;
    public Subjects() {
        this.subjects = new Subject[this.maxSubjects]; 
    }
    public Subjects(int inputSubject) {
        this.subjects = new Subject[inputSubject];
        // System.out.println("-"+numSubjects);
        // System.out.println("+" +this.subjects);
        for(int i=0; i<inputSubject; i++) {
            this.subjects[i] = new Subject();
        }
        this.maxSubjects = inputSubject;
    }
    public String[] getSubjectName() {
        String[] subjectName = new String[this.maxSubjects];
        // System.out.println(Arrays.toString(this.subjects));
        int i=0;
        for (Subject subject: this.subjects) {
            // System.out.println(subject);
            // System.out.println(i);
            if(subject != null) {
                subjectName[i]=subject.name;
            }
            i++;
        }
        return subjectName;
    }
    public int getTotalMarks() {
        int totalMarks = 0;
        for (Subject subject: this.subjects) {
            if(subject != null) {
                totalMarks+=subject.marks;
            }
        }
        return totalMarks;
    }
    public int getPercentage() {
        int totalMarks = getTotalMarks();
        System.out.println(totalMarks);
        return (totalMarks*100) / (this.maxSubjects*100);
    }
    public float getAverageMarks() {
        if (this.numSubjects == 0) {
            return 0;
        }
        int totalMarks= getTotalMarks();
        return totalMarks/this.numSubjects;
    }
    public void addSubject(String name, int marks) {
        if(this.numSubjects== this.maxSubjects){
            System.out.println("Max Number of Subjects reached");
        }
        this.subjects[this.numSubjects] = new Subject(name,marks);
        this.numSubjects++;
    }
    public String toString() {
        return Arrays.toString(subjects);
    }
}
