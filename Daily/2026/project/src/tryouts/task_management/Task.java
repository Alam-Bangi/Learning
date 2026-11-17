package tryouts.task_management;

public class Task {

    private int id;
    private String title;
    private String description;
    private String status;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = "PENDING"; // Default status
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
               ", Title: " + title +
               ", Description: " + description +
               ", Status: " + status;
    }
}
