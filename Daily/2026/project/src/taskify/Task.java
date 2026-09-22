package taskify;

public class Task {
    private String name;
    private String description;
    private boolean isCompleted;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        String status = isCompleted ? "Completed" : "Pending";
        return "Task Name: " + name + " | Description: " + description + " | Status: " + status;
    }
}