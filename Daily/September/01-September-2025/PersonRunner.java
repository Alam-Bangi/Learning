import java.util.Arrays;
import java.util.Scanner;

class PersonRunner {
    public static void main(String[] args) {
        // Person person = new Person("ABC", 'M', "Indian");
        // String[] subjects = {"Maths", "Science"};
        // int[] marks = {90, 87};
        // Student student = new Student("ABC", 'M', "Indian","S123", 10, subjects, marks); 
        Student student = new Student();
        student.setSubjects();
        // System.out.println(this);
        // System.out.println(person);
        System.out.println(student);
    }
}
class Person {
    String name;
    char gender;
    String nationality;
    public Person() {
        this.name = "ABC";
        this.gender = 'M';
        this.nationality = "INDIAN";
    }
    public Person(String name, char gender, String nationality) {
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String toString() {
        StringBuilder ps = new StringBuilder();
        ps.append("Name: ").append(name).append("\n").append("Gender: ").append(gender).append("\n").append("Nationality: ").append(nationality);
        return ps.toString();
    }
}
class Student extends Person {
    String student_id;
    int standard;
    String[] subjects;
    int[] marks;
    int inputFromUser=0;
    public Student() {
        this.student_id = "123";
        this.standard = 1;
        this.subjects = new String[]{"English"};
        this.marks = new int[]{0};
    }
    public Student(String name, char gender, String nationality, String student_id, int standard, String[] subjects, int[] marks) {
        super(name, gender, nationality);
        this.student_id = student_id;
        this.standard = standard;
        this.subjects= new String[subjects.length];
        for (int i=0; i<subjects.length; i++) {
            this.subjects[i] = subjects[i];
        }
        System.out.println(Arrays.toString(this.subjects));
        this.marks= new int[marks.length];
        for (int i=0; i<marks.length; i++) {
            this.marks[i] = marks[i];
        }
        System.out.println(Arrays.toString(this.marks));
        setNationality("Arabian");

    }
    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public int getStandard() {
        return standard;
    }
     public void setStandard(int standard) {
        this.standard = standard;
    }
    public String[] getSubjects() {
        return subjects;
    }
    public void setSubjects() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int inputFromUser = scanner.nextInt();
        for(int i = 0; i<inputFromUser; i++) {
            System.out.println("Enter subject name: ");
            String subjectName = scanner.nextLine();
            this.subjects[i]= subjectName;
            this.subjects.addSubject(subjectName);
        }
    }
    public int[] getMarks() {
        return marks;
    }
    public void setMarks(int[] marks) {
        this.marks = marks;
    }
    public void addSubject(String name) {
        this.subjects[this.inputFromUser]= new String();
    }
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Name: ").append(name).append("\n").append("Gender: ").append(gender).append("\n").append("Nationality: ").append(nationality).append("\n").append("My student id is ")
        .append(student_id).append("\n").append("I'm in standard ").append(standard).append("\n");
        if(subjects != null && marks!= null && subjects.length==marks.length) {   
            for (int i = 0; i < subjects.length; i++) {
                st.append("Subject:").append(subjects[i]).append(" Marks:").append(marks[i]).append("  ");
            }
        }
        return st.toString();
    }
}
