package tryouts.multi_threading.railway_station_system;

public class Train extends Thread {
    private RailwayStation station;

    public Train(RailwayStation station, String trainName) {
        super(trainName);
        this.station = station;
    }

    @Override
    public void run() {
        String trainName = getName();
        System.out.println("\n" + trainName + " started its journey.");

        int platform = station.trainArrival(trainName);
        if (platform == -1) {
            return;
        }

        try {
            System.out.println(trainName + " is standing at Platform " + platform);
            Thread.sleep(3000);

            System.out.println(trainName + ": Ready for departure.");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            station.trainDeparture(trainName, platform);
            return;
        }
        station.trainDeparture(trainName, platform);
        System.out.println(trainName + " journey completed successfully.");
    }
}
