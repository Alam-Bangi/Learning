import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.*;

class ScheduledMotorRunner {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        LocalTime startTime = LocalTime.of(8, 18);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime nextRun = now.withHour(startTime.getHour())
                .withMinute(startTime.getMinute())
                .withSecond(0);

        if (now.compareTo(nextRun) > 0) {
            nextRun = nextRun.plusDays(1);
        }

        long initialDelay = Duration.between(now, nextRun).toSeconds();

        Runnable startMotor = () -> {

            System.out.println("Motor Started");

            scheduler.schedule(() -> {
                System.out.println("Motor Stopped");
            }, 20, TimeUnit.MINUTES);
        };

        scheduler.scheduleAtFixedRate(
                startMotor,
                initialDelay,
                24 * 60 * 60,
                TimeUnit.SECONDS);

        System.out.println("Motor automation started...");
    }
}