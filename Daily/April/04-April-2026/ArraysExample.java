import java.util.Scanner;

class ArraysExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student student = new Student();
        System.out.println(student);

        System.out.println("Enter details for Student 1:");

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

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Setting to 0.");
                marks[i] = 0;
            }
            sc.nextLine();
        }

        Student student1 = new Student(name, subjects, marks);
        System.out.println();
        System.out.println(student1);

        Student student2 = new Student(
                "Abc",
                new String[] { "Math", "Science", "English" },
                new int[] { 85, 90, 75 });

        System.out.println(student2);

        sc.close();
    }
}

class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    public Student() {
        this.name = "XYZ";
        this.subjects = new String[] { "English" };
        this.marks = new int[] { 0 };
    }

    public Student(String name, String[] subjects, int[] marks) {
        if (subjects.length != marks.length) {
            System.out.println("Subjects and marks count must match.");
        }
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public void setMarks(int[] marks) {
        if (subjects.length != marks.length) {
            throw new IllegalArgumentException("Subjects and marks count must match.");
        }
        this.marks = marks;
    }

    public double getAverage() {
        if (marks.length == 0)
            return 0;

        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / (double) marks.length;
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("Student Name: ").append(name).append("\n");
        st.append("Subjects & Marks:\n");

        for (int i = 0; i < subjects.length; i++) {
            st.append(subjects[i])
                    .append(": ").append(marks[i])
                    .append("\n");
        }

        st.append("Average: ").append(getAverage()).append("\n");
        return st.toString();
    }
}