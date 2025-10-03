class MotorBikeRunner {
    public static void main(String[] args) {
        MotorBike ducati = new MotorBike();
        MotorBike honda = new MotorBike();

        ducati.start();
        honda.start();
    }
}

class MotorBike {
    void start() {
        System.out.println("Bike started");
    }
}