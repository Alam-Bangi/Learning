class MotorBikeRunner {
    public static void main(String[] args) {
        MotorBike ducati = new MotorBike();
        MotorBike honda = new MotorBike();

        ducati.start();
        honda.start();

        ducati.setSpeed(100);
        // System.out.println(ducati.getSpeed());
        honda.setSpeed(80);
        // System.out.println(honda.getSpeed());
        
        ducati.setSpeed(20);
        honda.setSpeed(0);
    }
}

class MotorBike {
    private int speed;

    int getSpeed() {
        return speed;
    }
    void setSpeed(int speed) {
        if(speed>0)
        this.speed = speed;
    }
    void start() {
        System.out.println("Bike started");
    }


}