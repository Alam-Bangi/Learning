package tryouts.multi_threading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class DigitalClock extends Thread {
    @Override
    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        while (true) {
            LocalTime time = LocalTime.now();
            System.out.println("Current Time: " + time.format(formatter));
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Clock stopped.");
                break;
            }
        }
    }
}

public class DigitalClockRunner {
    public static void main(String[] args) {
        DigitalClock clock = new DigitalClock();
        clock.start();
    }
}
