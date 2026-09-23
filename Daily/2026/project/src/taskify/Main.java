package taskify;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<User> allUsers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private boolean hasDefaultUsers = true;

    public Main() {
        User user1 = new User("Alam", "ab12@gmail.com");
        User user2 = new User("Aman", "cd0@gmail.com");

        user1.addTask(new Task("Default", "Tasks"));
        user2.addTask(new Task("Default", "Tasks"));

        allUsers.add(user1);
        allUsers.add(user2);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int choice;

        do {
            System.out.println("\n========== TASK MANAGER MENU ==========");
            System.out.println("0. Implement All (Default Demo)");
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
                    main.runDefaultImplementation();
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
                    System.out.println("Exiting program.Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 0 and 9.");
            }
        } while (choice != 9);
        sc.close();
    }

    private void runDefaultImplementation() {
        if (!hasDefaultUsers) {
            System.out.println("\nDefault users are no longer available because new users have been registered.");
            return;
        }

        System.out.println("\n========== DEFAULT USERS & TASKS ==========");
        for (User user : allUsers) {
            printUserDetails(user);
        }

        User user1 = getSpecificUser(allUsers, "ab12@gmail.com");
        if (user1 != null) {
            System.out.println();
            System.out.println("Removing task 'Study' from user 1 (if exists)");
            user1.removeTask("Study");
            System.out.println("Updating user 1 task description");
            user1.updateTaskDescription("Default", "Spring");
        }

        User user2 = getSpecificUser(allUsers, "cd0@gmail.com");
        if (user2 != null) {
            System.out.println("Updating user 2 task status");
            user2.updateTaskCompletion("Default", true);
        }

        System.out.println("\n--- After Default Operations ---");
        for (User user : allUsers) {
            printUserDetails(user);
        }
    }

    private User getSpecificUser(List<User> list, String mail) {
        for (User u : list) {
            if (u.getEmail().equalsIgnoreCase(mail)) return u;
        }
        return null;
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
        if (hasDefaultUsers) {
            allUsers.clear();
            hasDefaultUsers = false;
            System.out.println("Notice: Default users cleared. Switching exclusively to registered users.");
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
            System.out.println(" - (No tasks assigned)");
        } else {
            for (Task task : user.getTasks()) {
                System.out.println(" - " + task);
            }
        }
    }

    private void listAllUsers() {
        if (allUsers.isEmpty()) {
            System.out.println("No users registered!!");
            return;
        }
        for (User u : allUsers) {
            System.out.println(u);
        }
    }
}