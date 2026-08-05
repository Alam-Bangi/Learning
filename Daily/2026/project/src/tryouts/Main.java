package tryouts;

class Main {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        Flyable helicopter = new Helicopter();

        bird.fly();
        bird.flyUsing();

        System.out.println();

        helicopter.fly();
        helicopter.flyUsing();
    }
}