package tryouts.task_management;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(int id, String title, String description) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println("Task ID already exists!");
                return;
            }
        }
        Task task = new Task(id, title, description);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void updateStatus(int id, String status) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                if (status.equalsIgnoreCase("PENDING") ||
                    status.equalsIgnoreCase("COMPLETED")) {

                    task.setStatus(status.toUpperCase());
                    System.out.println("Task status updated!");
                } else {
                    System.out.println("Invalid status!");
                }
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);

        if (removed) {
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    public void searchTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println(task);
                return;
            }
        }
        System.out.println("Task not found!");
    }
}
