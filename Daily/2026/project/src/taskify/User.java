package taskify;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Task> tasks;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean removeTask(String taskName) {
        return tasks.removeIf(task -> task.getName().equalsIgnoreCase(taskName));
    }

    public boolean updateTaskDescription(String taskName, String newDescription) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                task.setDescription(newDescription);
                return true;
            }
        }
        return false;
    }

    public boolean updateTaskCompletion(String taskName, boolean isCompleted) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                task.setCompleted(isCompleted);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}