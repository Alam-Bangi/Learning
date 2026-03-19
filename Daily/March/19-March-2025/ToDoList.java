import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> tasks = new ArrayList<>();
    static int numberOfTasks;

    public static void main(String[] args) {

        System.out.print("Enter how many tasks you want to create: ");
        numberOfTasks = scanner.nextInt();

        menu();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        while (choice != 4) {
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    viewTasks();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            menu();
            choice = scanner.nextInt();
        }
    }

    public static void menu() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. View all tasks");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void addTask() {
        System.out.println("Enter the task: ");
        String task = scanner.next();
        tasks.add(task);

        if (tasks.size() > numberOfTasks) {
            System.out.println("You cannot add more than " + numberOfTasks + " tasks");
            tasks.remove(task);
        }
    }

    public static void removeTask() {
        System.out.println("Enter the index of the task to remove: ");
        int index = scanner.nextInt();

        if (index > 0 && index <= tasks.size()) {
            if (index > 1 && index < tasks.size()) {
                tasks.remove(index - 1);
            } else {
                tasks.remove(0);
            }
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show");
        } else {
            System.out.println("Your tasks are -");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + " : " + tasks.get(i));
            }
        }
    }
}
