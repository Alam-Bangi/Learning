package tryouts.task_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskService service = new TaskService();

        while (true) {
            System.out.println("\n===== TASK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    service.addTask(id, title, description);
                    break;
                case 2:
                    service.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter Task ID: ");
                    int taskId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Status (PENDING/COMPLETED): ");
                    String status = sc.nextLine();

                    service.updateStatus(taskId, status);
                    break;
                case 4:
                    System.out.print("Enter Task ID: ");
                    int deleteId = sc.nextInt();

                    service.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.print("Enter Task ID: ");
                    int searchId = sc.nextInt();

                    service.searchTask(searchId);
                    break;
                case 6:
                    System.out.println("Exiting application...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
