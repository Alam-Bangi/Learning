import java.util.*;

class OfficePrinterRunner {

    static Scanner sc = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {

        PriorityQueue<PrintTask> printer = new PriorityQueue<>(new TaskComparator());

        while (true) {
            System.out.println("\n=== OFFICE PRINTER SYSTEM ===");
            System.out.println("1. Add Task");
            System.out.println("2. Print Task");
            System.out.println("3. View Next Task");
            System.out.println("4. Show All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    addTask(printer);
                    break;

                case 2:
                    printTask(printer);
                    break;

                case 3:
                    viewTask(printer);
                    break;

                case 4:
                    showTasks(printer);
                    break;

                case 5:
                    System.out.println("Printer stopped.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask(PriorityQueue<PrintTask> printer) {
        System.out.print("Enter document name: ");
        String name = sc.nextLine();

        System.out.print("Enter department (HR / ADMIN / EMPLOYEE): ");
        String dept = sc.nextLine().toUpperCase();

        while (!dept.equals("HR") &&
                !dept.equals("ADMIN") &&
                !dept.equals("EMPLOYEE")) {

            System.out.print("Enter valid department (HR / ADMIN / EMPLOYEE): ");
            dept = sc.nextLine().toUpperCase();
        }

        System.out.print("Enter deadline (in minutes): ");
        int deadline = sc.nextInt();

        PrintTask task = new PrintTask(name, dept, deadline, count++);
        printer.offer(task);

        System.out.println("Task added.");
    }

    static void printTask(PriorityQueue<PrintTask> printer) {
        if (printer.isEmpty()) {
            System.out.println("No tasks to print.");
            return;
        }

        System.out.println("Printing: " + printer.poll());
    }

    static void viewTask(PriorityQueue<PrintTask> printer) {
        if (printer.isEmpty()) {
            System.out.println("No tasks in queue.");
            return;
        }

        System.out.println("Next: " + printer.peek());
    }

    static void showTasks(PriorityQueue<PrintTask> printer) {
        if (printer.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("All Tasks:");
        for (PrintTask t : printer) {
            System.out.println(t);
        }
    }
}

class PrintTask {

    String name;
    String dept;
    int deadline;
    int order;

    PrintTask(String name, String dept, int deadline, int order) {
        this.name = name;
        this.dept = dept;
        this.deadline = deadline;
        this.order = order;
    }

    public String toString() {
        return name + " [" + dept + ", deadline: " + deadline + " min]";
    }
}

class TaskComparator implements Comparator<PrintTask> {

    private int getDeptPriority(String dept) {
        switch (dept) {
            case "HR":
                return 1;
            case "ADMIN":
                return 2;
            default:
                return 3;
        }
    }

    public int compare(PrintTask t1, PrintTask t2) {

        if (t1.deadline != t2.deadline) {
            return t1.deadline - t2.deadline;
        }

        int d1 = getDeptPriority(t1.dept);
        int d2 = getDeptPriority(t2.dept);

        if (d1 != d2) {
            return d1 - d2;
        }

        return t1.order - t2.order;
    }
}