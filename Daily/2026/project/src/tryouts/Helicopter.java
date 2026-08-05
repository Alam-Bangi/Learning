package tryouts;

class Helicopter extends Flyable {
    void fly() {
//        super.fly();
        System.out.println("Helicopter is flying");
    }
    @Override
    void flyUsing() {
        System.out.println("Helicopter fly using motor-blades");
    }
}