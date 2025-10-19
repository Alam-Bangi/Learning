class FanRunner {
    public static void main(String[] args) {
        Fan fan = new Fan("M", 1, "Black");
        fan.switchOn();
        System.out.println(fan);
        fan.setSpeed((byte)3);
        System.out.println(fan);
        fan.switchOff();
        System.out.println(fan);
    }
}
class Fan {
    private String make;
    private double radius;
    private String colour;
    private boolean isOn;
    private byte speed;
    
    public Fan (String make, double radius, String colour) {
        this.make=make;
        this.radius = radius;
        this.colour = colour;
    }
    
    public void switchOn() {
        this.isOn= true;
        setSpeed((byte)5);
    }
    public void switchOff() {
        this.isOn= false;
        setSpeed((byte)0);
    }
    public void setSpeed(byte speed) {
        this.speed = speed;
    }
    public String toString() {
        return String.format("make-%s , radius-%f , colour-%s , isOn-%b , speed-%d ", make, radius, colour, isOn, speed);
    }
}
    