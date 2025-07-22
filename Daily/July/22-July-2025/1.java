public class motorBikeRunner {
    public static void main(String[] args) {
        motorBike ducati = new motorBike();
        motorBike honda = new motorBike();
        
        ducati.start();
        honda.start();
        
        ducati.setSpeed(100);
        System.out.println(ducati.getSpeed());
        honda.setSpeed(80);
        System.out.println(honda.getSpeed());
        
    }
}
    
    public class motorBike {
       private int speed;
       
       public int getSpeed() {
            return speed;
        }
        
       public void setSpeed(int speed) {
            this.speed = speed;
        }
        
        void start() {
            System.out.println("Bike started.");
        }
    }
    
