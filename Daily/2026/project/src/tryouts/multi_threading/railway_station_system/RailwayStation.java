package tryouts.multi_threading.railway_station_system;

public class RailwayStation {
    private Platform[] platforms = {
            new Platform(1),
            new Platform(2)
    };

    public synchronized int trainArrival(String trainName) {
        System.out.println("\n" + trainName + " is requesting platform.");
        while (true) {
            for (Platform p : platforms) {
                if (!p.isOccupied()) {
                    p.setOccupied(true);
                    System.out.println("--------------------------------");
                    System.out.println("Announcement: " + trainName + " is arriving at the station.");

                    System.out.println(trainName + " arrived at Platform " + p.getPlatformNumber());
                    return p.getPlatformNumber();
                }
            }
            System.out.println("All platforms are occupied!");
            System.out.println(trainName + " is waiting for an empty platform.");

            try {
                wait();
                System.out.println(trainName + " received platform availability notification.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }
    }

    public synchronized void trainDeparture(String trainName, int platformNumber) {
        System.out.println("\n" + trainName + " is preparing for departure.");

        System.out.println("Departure signal received for " + trainName);
        System.out.println("Announcement: " + trainName + " is departing from Platform " + platformNumber);
        System.out.println(trainName + " departed successfully!");

        platforms[platformNumber - 1].setOccupied(false);
        System.out.println("Platform " + platformNumber + " is now EMPTY.");
        System.out.println("Announcement: Platform " + platformNumber + " is now available for the next train.");
        displayAllPlatforms();
        notifyAll();
    }

    public synchronized void displayAllPlatforms() {
        System.out.println("\nCurrent Platform Status:");
        for (Platform p : platforms) {
            p.displayPlatformStatus();
        }
        System.out.println("--------------------------------");
    }
}
