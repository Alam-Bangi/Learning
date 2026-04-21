import java.util.*;
import java.util.List;

class AttendanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int choice = 0;
        boolean isMarked = false;

        do {
            System.out.println("\n===== Attendance Menu =====");
            System.out.println("1. Add Students");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Display Attendance");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of students: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter name: ");
                        String name = sc.next();

                        System.out.print("Enter roll no: ");
                        int roll = sc.nextInt();

                        boolean exists = false;
                        for (Student s : students) {
                            if (s.rollNo == roll) {
                                exists = true;
                                break;
                            }
                        }
                        if (exists) {
                            System.out.println("Roll number already exists. Try again.");
                            i--;
                            continue;
                        }
                        students.add(new Student(roll, name));
                    }
                    break;

                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No students available. Add students first.");
                        break;
                    }
                    System.out.println("Mark attendance:");
                    for (Student s : students) {
                        System.out.print("Roll No " + s.rollNo + " (" + s.name + ") - Present/Absent: ");
                        String status = sc.next();
                        s.status = status;
                        isMarked = true;
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students to display.");
                        break;
                    } else if (isMarked == true) {
                        int present = 0, absent = 0;
                        System.out.println("\nStudent Attendance List:");
                        for (Student s : students) {
                            System.out.println(s.rollNo + " - " + s.name + " - " + s.status);
                            if (s.status.equalsIgnoreCase("Present")) {
                                present++;
                            } else {
                                absent++;
                            }
                        }
                        System.out.println("\nTotal Present: " + present);
                        System.out.println("Total Absent: " + absent);
                    } else {
                        System.out.println("Attendance not marked yet.");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }
                    boolean found = false;
                    while (!found) {
                        System.out.print("Enter roll number to search: ");
                        int searchRoll = sc.nextInt();

                        for (Student s : students) {
                            if (s.rollNo == searchRoll) {
                                System.out.println(s.name);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Roll no not found. Please enter a valid number");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}

class Student {
    int rollNo;
    String name;
    String status;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.status = "Absent";
    }
}