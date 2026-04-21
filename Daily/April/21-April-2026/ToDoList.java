import java.util.*;

class TodoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        int choice = 0;

        do {
            System.out.println("\n===== TO-DO MENU =====");
            System.out.println("1. Add Tasks");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Show Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("How many tasks do you want to add? ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid number!");
                        sc.next();
                        break;
                    }

                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter task " + (i + 1) + ": ");
                        String title = sc.nextLine();
                        tasks.add(new Task(title));
                    }

                    System.out.println(n + " task(s) added.");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    showTasks(tasks);

                    System.out.print("Enter task number to delete: ");
                    int del = sc.nextInt();

                    if (del > 0 && del <= tasks.size()) {
                        tasks.remove(del - 1);
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    showTasks(tasks);

                    System.out.print("Enter task number to mark completed: ");
                    int comp = sc.nextInt();

                    if (comp > 0 && comp <= tasks.size()) {
                        tasks.get(comp - 1).isCompleted = true;
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to display.");
                    } else {
                        showTasks(tasks);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    public static void showTasks(List<Task> tasks) {
        System.out.println("\nTask List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String status = t.isCompleted ? "Completed" : "Pending";
            System.out.println((i + 1) + ". " + t.title + " [" + status + "]");
        }
    }
}

class Task {
    String title;
    boolean isCompleted;

    Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }
}