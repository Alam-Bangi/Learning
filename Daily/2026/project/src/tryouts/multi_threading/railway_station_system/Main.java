package tryouts.multi_threading.railway_station_system;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("       INDIAN RAILWAY STATION");
        System.out.println("       MANAGEMENT SYSTEM");
        System.out.println("======================================");

        System.out.println("Station is now OPEN.");
        System.out.println("Total Platforms: 2");
        System.out.println("Total Trains: 5");
        System.out.println("Waiting for trains...");

        RailwayStation station = new RailwayStation();
        station.displayAllPlatforms();

        Train t1 = new Train(station, "Vande Bharat Express");
        Train t2 = new Train(station, "Rajdhani Express");
        Train t3 = new Train(station, "Shatabdi Express");
        Train t4 = new Train(station, "Duronto Express");
        Train t5 = new Train(station, "Garib Rath Express");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Station operation interrupted.");
        }

        System.out.println("\n======================================");
        System.out.println("ALL TRAINS COMPLETED THEIR JOURNEY.");
        System.out.println("RAILWAY STATION OPERATIONS COMPLETED.");
        System.out.println("======================================");
        station.displayAllPlatforms();
    }
}
