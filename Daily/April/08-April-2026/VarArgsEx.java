
import java.util.Scanner;

class VarArgsEx {
    public static void main(String[] args) {
        Student student = addStudent();
        System.out.println(student);

        Student student2 = addStudent();
        System.out.println(student2);

    }

    public static Student addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int count = sc.nextInt();
        sc.nextLine();

        String[] subjects = new String[count];
        int[] marks = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();
            System.out.print("Enter marks for " + subjects[i] + ": ");
            marks[i] = sc.nextInt();
            sc.nextLine();
        }
        return new Student(name, subjects, marks);
    }
}

class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    Student() {
    }

    Student(String name, String[] subjects, int[] marks) {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public double getAverage() {
        if (marks.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        for (int i = 0; i < subjects.length; i++) {
            sb.append(subjects[i]).append(": ").append(marks[i]).append("\n");
        }
        sb.append("Average: ").append(getAverage()).append("\n");
        return sb.toString();
    }
}