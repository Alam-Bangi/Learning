package taskify;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<User> allUsers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private List<User> defaultUsers = new ArrayList<>();

    public Main() {
        this.defaultUsers = List.of(new User("Alam","ab12@gmail.com"),new User("Aman", "cd0@gmail.com"));
        for(User user : defaultUsers) {
            user.addTask(new Task("Default", "Tasks"));
        }
    }

    public static void main(String[] args) {
        Main defaultValues = new Main();
        Main main = new Main();
        int choice;
        do {
            System.out.println("\n========== TASK MANAGER MENU ==========");
            System.out.println("0. Implement All");
            System.out.println("1. Register New User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Update Task Description");
            System.out.println("4. Change Task Completion Status");
            System.out.println("5. Remove Task");
            System.out.println("6. Display All Users and Their Tasks");
            System.out.println("7. Find User by Email (View Name & Tasks)");
            System.out.println("8. List all users");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (0-9): ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (0-9): ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    defaultValues.displayAllUsers();
                    defaultValues.removeTaskFromDefaultUser();
                    defaultValues.updateDefaultTaskDesc("ab12@gmail.com", "Spring");
                    defaultValues.updateDefaultTaskStatus("cd0@gmail.com");
                    defaultValues.removeTaskFromDefaultUser();
                    break;
                case 1:
                    main.registerUser();
                    break;
                case 2:
                    main.addTaskToUser();
                    break;
                case 3:
                    main.updateTaskDesc();
                    break;
                case 4:
                    main.updateTaskStatus();
                    break;
                case 5:
                    main.removeTaskFromUser();
                    break;
                case 6:
                    main.displayAllUsers();
                    break;
                case 7:
                    main.findUserByEmail();
                    break;
                case 8:
                    main.listAllUsers();
                    break;
                case 9:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 8.");
            }
        } while (choice != 8);

        sc.close();
    }

    private void registerUser() {
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        System.out.print("Enter User Email: ");
        String email = sc.nextLine();

        if (getUserByEmail(email) != null) {
            System.out.println("Error: User with this email already exists!");
            return;
        }

        allUsers.add(new User(name, email));
        System.out.println("User registered successfully!");
    }

    private void addTaskToUser() {
        User user = getUser();
        if (user == null) return;

        System.out.print("Enter Task Name: ");
        String taskName = sc.nextLine();
        System.out.print("Enter Task Description: ");
        String taskDesc = sc.nextLine();

        user.addTask(new Task(taskName, taskDesc));
        System.out.println("Task added successfully to " + user.getName() + "!");
    }

    private void updateTaskDesc() {
        User user = getUser();
        if (user == null) return;

        System.out.print("Enter the name of the task to update: ");
        String taskName = sc.nextLine();
        System.out.print("Enter new description: ");
        String newDesc = sc.nextLine();

        if (user.updateTaskDescription(taskName, newDesc)) {
            System.out.println("Task description updated successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private void updateDefaultTaskDesc(String mail, String newDesc) {
        User user = getUser(mail);
        String taskName = "Default";
        if (user.updateTaskDescription(taskName, newDesc)) {
            System.out.println("Task description updated successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private void updateTaskStatus() {
        User user = getUser();
        if (user == null) return;

        System.out.print("Enter the name of the task to update status: ");
        String taskName = sc.nextLine();
        System.out.print("Is the task completed? (true/false): ");

        while (!sc.hasNextBoolean()) {
            System.out.print("Please enter true or false: ");
            sc.next();
        }
        boolean isCompleted = sc.nextBoolean();
        sc.nextLine();

        if (user.updateTaskCompletion(taskName, isCompleted)) {
            System.out.println("Task completion status updated!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private void updateDefaultTaskStatus(String mail) {
        User user = getUser(mail);

        String taskName = "Default";
        boolean isCompleted = true;

        if (user.updateTaskCompletion(taskName, isCompleted)) {
            System.out.println("Task completion status updated!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private void removeTaskFromUser() {
        User user = getUser();
        if (user == null) return;

        System.out.print("Enter the name of the task to remove: ");
        String taskName = sc.nextLine();

        if (user.removeTask(taskName)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private void removeTaskFromDefaultUser() {
        User user = getUser("ab12@gmail.com");
        String taskName = "Study";

        if (user.removeTask(taskName)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private User getUser(String mail) {
        for(User u : defaultUsers) {
            if(u.getEmail().equals(mail))
                return u;
        }
        return null;
    }

    private void displayAllUsers() {
        if (allUsers.isEmpty()) {
            System.out.println("\nNo users registered in the system yet.");
            return;
        }

        System.out.println("\n========== ALL USERS & TASKS ==========");
        for (User user : allUsers) {
            printUserDetails(user);
        }
    }

    private void findUserByEmail() {
        User user = getUser();
        if (user != null) {
            System.out.println("\n========== USER FOUND ==========");
            printUserDetails(user);
        }
    }

    private User getUserByEmail(String email) {
        for (User user : allUsers) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    private User getUser() {
        if (allUsers.isEmpty()) {
            System.out.println("No users available. Please register a user first.");
            return null;
        }
        System.out.print("Enter User Email: ");
        String email = sc.nextLine();
        User user = getUserByEmail(email);
        if (user == null) {
            System.out.println("User not found!");
        }
        return user;
    }

    private void printUserDetails(User user) {
        System.out.println("User Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Tasks:");
        if (user.getTasks().isEmpty()) {
            System.out.println("  - (No tasks assigned)");
        } else {
            for (Task task : user.getTasks()) {
                System.out.println(" - " + task);
            }
        }
    }

    private void listAllUsers() {
        if(allUsers.isEmpty()) {
            System.out.println("No users registered!!");
        }
        for (User u : allUsers) {
            System.out.println(u);
        }

    }
}
