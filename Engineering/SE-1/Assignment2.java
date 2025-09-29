import java.util.Arrays;
import java.util.Scanner;

class Assignment2 {
    String[] seStudents = new String[] {};
    int[] fdsMarks = new int[] {};

    boolean isSeStudentsInput = false;
    boolean isFdsMarksInput = false;
    boolean isAbsent = false;

    public Assignment2() {
        this.seStudents = new String[]{"a","b","c","d","e","f"};
        this.fdsMarks = new int[]{10,20,30,40,50,60};
    }
    public Assignment2(String[] seStudents, int[] fdsMarks) {
        this.seStudents = seStudents;
        this.fdsMarks = fdsMarks;
    }
    public void getSeStudents() {
         System.out.println("SE Students are: " + Arrays.toString(seStudents));
    }
    public String[] setSeStudents() {
        System.out.println("Enter the number of students: ");
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
        this.seStudents = new String[noOfStudents];
        for (int i=0; i<noOfStudents; i++) {
            System.out.println("Enter name of student "+(i+1)+":");
            String studentName = scanner.next();
            this.seStudents[i] = studentName;
        }
        isSeStudentsInput = true;
        System.out.println("Students in SE are "+ Arrays.toString(seStudents));
        return seStudents;
    }
    public void getFdsMarks() {
        System.out.println("FDS Marks are: " + Arrays.toString(fdsMarks));
    }
    public int[] AddFdsMarks() {
        System.out.println("Enter the number of students: ");
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
        if(noOfStudents > seStudents.length) {
            System.out.println("Number of students cannot be more than "+seStudents.length);
            return fdsMarks;
        }
        this.fdsMarks = new int[noOfStudents];
        for (int i=0; i<noOfStudents; i++) {
            System.out.println("Enter FDS marks of student "+(i+1)+":");
            int mark = scanner.nextInt();
            this.fdsMarks[i] = mark;
        }
        isFdsMarksInput = true;
        System.out.println("FDS Marks are "+ Arrays.toString(fdsMarks));
        return fdsMarks;
    }
    public void AverageFDSMarks() {
        int sum = 0;
        for (int mark : fdsMarks) {
            sum = sum + mark;
        }
        System.out.println("Average of FDS Marks is " + sum / fdsMarks.length);
    }
    public void highestFDSMarks() {
        int highest = fdsMarks[0];
        for (int mark : fdsMarks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        System.out.println("Highest of FDS Marks is " + highest);
    }
    public void lowestFDSMarks() {
        int lowest = fdsMarks[0];
        for (int mark : fdsMarks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        System.out.println("Lowest of FDS Marks is " + lowest);
    }
    public void absentStudents() {
        int absentCount = seStudents.length - fdsMarks.length;
        System.out.println("Number of absent students are " + absentCount);
    }
    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        int choice = 0;
        while (choice != 7) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("0. Implement All");
            System.out.println("1. Set Students");
            System.out.println("2. Add FDS Marks");
            System.out.println("3. Average of FDS Marks");
            System.out.println("4. Highest of FDS Marks");
            System.out.println("5. Lowest of FDS Marks");
            System.out.println("6. Count of Absent Students");
            System.out.println("7. Exit");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch(choice) {
                case 0:
                    assignment2.getSeStudents();
                    assignment2.getFdsMarks();
                    assignment2.AverageFDSMarks();
                    assignment2.highestFDSMarks();
                    assignment2.lowestFDSMarks();
                    assignment2.absentStudents();
                    break;
                case 1:
                    assignment2.setSeStudents();
                    break;
                case 2:
                    if(assignment2.isSeStudentsInput) {
                        assignment2.AddFdsMarks();
                    } else {
                        System.out.println("Please enter students first");
                    }
                    break;
                case 3:
                    if(assignment2.isFdsMarksInput) {
                        assignment2.AverageFDSMarks();
                    } else {
                        System.out.println("Please enter FDS marks first");
                    }
                    break;
                case 4:
                    if(assignment2.isFdsMarksInput) {
                        assignment2.highestFDSMarks();
                    } else {
                        System.out.println("Please enter FDS marks first");
                    }
                    break;
                case 5:
                    if(assignment2.isFdsMarksInput) {
                        assignment2.lowestFDSMarks();
                    } else {
                        System.out.println("Please enter FDS marks first");
                    }
                    break;
                case 6:
                    if(assignment2.isSeStudentsInput && assignment2.isFdsMarksInput) {
                        assignment2.absentStudents();
                    } else {
                        System.out.println("Please enter students and FDS marks first");
                    }
                    break;
                case 7:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}