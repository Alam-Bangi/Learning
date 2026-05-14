import java.util.Scanner;
import java.util.concurrent.*;

class ReminderApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String message = sc.nextLine();

        System.out.println("Enter time interval in seconds: ");
        int seconds = sc.nextInt();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable reminderTask = () -> {
            System.out.println("Reminder: " + message);
        };

        scheduler.scheduleAtFixedRate(
                reminderTask,
                0,
                seconds,
                TimeUnit.SECONDS);
    }
}