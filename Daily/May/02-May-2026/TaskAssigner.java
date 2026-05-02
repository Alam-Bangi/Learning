import java.util.*;

class TaskAssigner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<CloudTask> tasks = new ArrayList<>();
        List<ServerJob> jobs = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== CLOUD SCHEDULER MENU =====");
            System.out.println("1. Add Cloud Task");
            System.out.println("2. Add Server Job");
            System.out.println("3. View Cloud Tasks");
            System.out.println("4. View Server Jobs");
            System.out.println("5. Schedule Cloud Tasks");
            System.out.println("6. Schedule Server Jobs");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Task Name: ");
                    String tName = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    tasks.add(new CloudTask(tName, priority));
                    break;

                case 2:
                    System.out.print("Enter Job ID: ");
                    String jobId = sc.nextLine();
                    System.out.print("Enter Load Weight: ");
                    int load = sc.nextInt();
                    jobs.add(new ServerJob(jobId, load));
                    break;

                case 3:
                    System.out.println("\nCloud Tasks:");
                    for (CloudTask t : tasks) {
                        System.out.println(t);
                    }
                    break;

                case 4:
                    System.out.println("\nServer Jobs:");
                    for (ServerJob j : jobs) {
                        System.out.println(j);
                    }
                    break;

                case 5:
                    Scheduler.schedule(tasks);
                    System.out.println("Cloud Tasks Scheduled (Sorted by Priority)");
                    break;

                case 6:
                    Scheduler.schedule(jobs);
                    System.out.println("Server Jobs Scheduled (Sorted by Load)");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}

class CloudTask implements Comparable<CloudTask> {

    String taskName;
    int priority;

    CloudTask(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    public int compareTo(CloudTask other) {
        return other.priority - this.priority;
    }

    public String toString() {
        return taskName + " Priority: " + priority;
    }
}

class ServerJob implements Comparable<ServerJob> {

    String jobId;
    int loadWeight;

    ServerJob(String jobId, int loadWeight) {
        this.jobId = jobId;
        this.loadWeight = loadWeight;
    }

    public int compareTo(ServerJob other) {
        return other.loadWeight - this.loadWeight;
    }

    public String toString() {
        return jobId + " Load: " + loadWeight;
    }
}

class Scheduler {

    public static <T extends Comparable<T>> void schedule(List<T> list) {
        Collections.sort(list);
    }
}
