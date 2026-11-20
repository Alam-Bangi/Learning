package tryouts.multi_threading.railway_station_system;

public class Platform {
    private int platformNumber;
    private boolean isOccupied;

    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.isOccupied = false;

        System.out.println("Platform " + platformNumber + " is ready.");
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public void displayPlatformStatus() {
        if (isOccupied) {
            System.out.println("Platform " + platformNumber + " : OCCUPIED");
        } else {
            System.out.println("Platform " + platformNumber + " : EMPTY");
        }
    }
}
