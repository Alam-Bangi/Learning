class AnimalRunner {
    public static void main(String[] args) {
        Animal[] animals = {new Goat(), new Cat()};
        for(Animal animal:animals) {
            animal.says();
        }
    }
}
interface Animal {
    void says();
}
class Goat implements Animal {
    public void says() {
        System.out.println("Goat says Mmmmmmmhhhhhhh!!!!!!");
    }
}
class Cat implements Animal {
    public void says() {
        System.out.println("Cat says Meow!!!");
    }
}