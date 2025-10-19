class FlyableRunner {
    public static void main(String[] args) {
        Flyable[] flyingObjects = {new Bird(), new Aeroplane()};
        for (Flyable object : flyingObjects) {
            object.fly();
        }
    }
}
interface Flyable {
    void fly();
}
class Bird implements Flyable {
    public void fly() {
        System.out.println("Birds fly with wings");
    }
}
class Aeroplane implements Flyable {
    public void fly() {
        System.out.println("Aeroplanes fly with fuel");
    }
}