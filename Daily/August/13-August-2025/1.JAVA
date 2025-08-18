import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentRunner {
    
    public static void main(String[] args) {

        
        
        Student student = new Student("Ranga", 97,98,100);
        Student student1 = new Student("Eve", 98,99,94,96);
        /** 
        int number = student1.getNumberOfMarks();
        System.out.println("number of marks: "+number);
        
        int sum = student1.getTotalSumOfMarks();
        System.out.println("sum of marks: "+sum);
        
        int maximumMark = student1.getMaximumMarks();
        System.out.println("maximum marks: "+maximumMark);
        
        int minimumMark = student1.getMinimumMarks();
        System.out.println("minimum marks: "+minimumMark);
        
        BigDecimal averageMark = student.getAverageMarks();
        System.out.println("average marks: "+averageMark);
        **/
        // System.out.println(student);
        // student.addNewMark(35);
        // System.out.println(student);
        // student.removeMark(1);
        // System.out.println(student);
        // student1.addNewMark(35);
        // System.out.println(student1);
        
        
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        
        Address address = new Address(246, "Ghorpade peth", "Pune", "Maharashtra", 411042);
        BirthDate birthDate = new BirthDate(12,11,2002);
        Person person = new Person("Alam", birthDate, "9373807292", address);
        System.out.println(person);
        
    }
}

public class Student{
    private String name;
    private ArrayList<Integer> marks=new ArrayList<Integer>();
    
    public Student(String name, int... marks) {
        this.name = name;
        for(int mark:marks) {
            this.marks.add(mark);
        }
    } 
    public int getNumberOfMarks() {
        return marks.size();
    }
    
     public int getTotalSumOfMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    public int getMaximumMarks() {
        
        return Collections.max(marks);
    }

    public int getMinimumMarks() {
       
        return Collections.min(marks);
    }
    
    public BigDecimal getAverageMarks() {
        int sum= getTotalSumOfMarks();
        int number= getNumberOfMarks();
        return new BigDecimal(sum).divide(new BigDecimal(number), 2, RoundingMode.HALF_UP);
    }
    public void addNewMark(int mark) {
        marks.add(mark);
        
    }
    public void removeMark(int index) {
        marks.remove(index);
        
    }
    
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("My name is ").append(name).append("\n").append("My marks are ")
        .append(marks).append("\n").append("My max marks are ").append(this.getMaximumMarks()).append("\n").append("My minimum marks are ").append(this.getMinimumMarks()).append("\n").append("My average marks are ").append(this.getAverageMarks()).append("\n");
        return sb.toString();
        // return name + marks;
    }
}

public class Person {
    String name;
    BirthDate birthDate;
    String mobileNumber;
    Address address;
    public Person(String name, BirthDate birthDate, String mobileNumber, Address address) {
        this.name=name;
        this.birthDate = birthDate;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }
   
    public String toString() {
        StringBuilder ps = new StringBuilder();
        ps.append("My name is ").append(name).append("\n").append("My birthdate is ").append(birthDate).append("\n").append("My mobile number is ").append(mobileNumber).append("\n").append("My address is ").append(address);
        return ps.toString();
    }
}

public class BirthDate {
    int day;
    int month;
    int year;
    int age;
    public BirthDate(int day, int month, int year) {
        this.day = day;
        this.month= month; 
        this.year= year;
        this.age = this.getAge(year);
    }
    public int getAge(int year) {
        // int currentYear;
        // int currentMonth;
        // int currentDay;
        LocalDate currentDate = LocalDate.now();
        int myAge= (currentDate.getYear()-1)-year;
        if (currentDate.getMonthValue()>=month || (currentDate.getDayOfMonth()>day && currentDate.getMonthValue()==month)) {
            myAge+=1;
        }
        return myAge;
    }
    public String toString() {
        StringBuilder bd=  new StringBuilder();
        bd.append(day).append("-").append(month).append("-").append(year).append("\n").append("My age is ").append(this.age);
        return bd.toString();
    }
}

public class Address {
        int flatNo;
        String streetName;
        String city;
        String state;
        int pincode;
        public Address(int flatNo, String streetName, String city, String state, int pincode) {
        this.flatNo =flatNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    public String toString() {
        StringBuilder ad=  new StringBuilder();
        ad.append(flatNo).append(", ").append(streetName).append(", ").append(city).append("-").append(pincode);
        return ad.toString();
    }
}