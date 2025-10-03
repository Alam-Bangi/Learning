class MotorBikeRunner {
    public static void main(String[] args) {
        MotorBike ducati = new MotorBike();
        MotorBike honda = new MotorBike();

        ducati.start();
        honda.start();

        ducati.setSpeed(100);
        honda.setSpeed(80);
        
        ducati.increaseSpeed(20);
        honda.increaseSpeed(30);

        ducati.decreaseSpeed(10);
        honda.decreaseSpeed(5);

        System.out.println(ducati.getSpeed());
        System.out.println(honda.getSpeed());

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
    void increaseSpeed(int howMuch) {
        setSpeed(this.speed + howMuch);
    }
    void decreaseSpeed(int howMuch) {
        setSpeed(this.speed - howMuch);
    }

}