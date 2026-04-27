import java.util.*;

class CourseEnrollment {

    static Scanner sc = new Scanner(System.in);

    private Map<Character, Set<String>> enrolledStudents;

    public CourseEnrollment() {
        enrolledStudents = new HashMap<>();
    }

    public static void main(String[] args) {
        CourseEnrollment enrollment = new CourseEnrollment();

        int choice;
        do {
            System.out.println("\n----Welcome to Course Enrollment System----");
            System.out.println("1. Enroll (Add)");
            System.out.println("2. Un-enroll (Remove)");
            System.out.println("3. Display All");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    enrollment.enroll();
                    break;
                case 2:
                    enrollment.unenroll();
                    break;
                case 3:
                    enrollment.displayAll();
                    break;
                case 4:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }

    private char getValidCourse() {
        System.out.print("Enter Course-Id (M-Maths / S-Science / C-Computer): ");
        char course = Character.toUpperCase(sc.next().charAt(0));

        while (course != 'M' && course != 'S' && course != 'C') {
            System.out.print("Enter valid course (M/S/C): ");
            course = Character.toUpperCase(sc.next().charAt(0));
        }
        sc.nextLine();
        return course;
    }

    public void enroll() {
        char course = getValidCourse();

        System.out.print("Enter Student Name: ");
        String student = sc.nextLine().trim().toUpperCase();

        enrolledStudents.putIfAbsent(course, new HashSet<>());

        if (enrolledStudents.get(course).contains(student)) {
            System.out.println("Student already enrolled in this course");
        } else {
            enrolledStudents.get(course).add(student);
            System.out.println("Enrollment successful!");
        }
    }

    public void unenroll() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No Students enrolled");
            return;
        }

        char course = getValidCourse();

        if (!enrolledStudents.containsKey(course)) {
            System.out.println("No students in this course");
            return;
        }

        System.out.print("Enter Student Name: ");
        String student = sc.nextLine().trim().toUpperCase();

        Set<String> students = enrolledStudents.get(course);

        if (students.remove(student)) {
            System.out.println("Student removed successfully!");
            if (students.isEmpty()) {
                enrolledStudents.remove(course);
            }
        } else {
            System.out.println("Student not found in this course");
        }
    }

    public void displayAll() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No Students enrolled");
            return;
        }

        for (Map.Entry<Character, Set<String>> entry : enrolledStudents.entrySet()) {
            System.out.println("\nCourse: " + entry.getKey());
            for (String student : entry.getValue()) {
                System.out.println(" - " + student);
            }
        }
    }
}
