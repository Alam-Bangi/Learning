class AnimalRunner {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Cat cat = new Cat();
        Animal animal1 = new Dog();
        Dog dog = new Dog();
        
        // animal.wakeup();  Cannot call this method as its not a part of abstract class
        animal.sleep();
        cat.wakeup();
        // cat.sleep();
        // animal1.sleep();
        dog.makeSound();
        dog.sleep();
    }
}
// abstract class Animal {
//     void sleep() {
//         System.out.println("Animal");
//     }
// }
interface Animal {
    abstract void sleep();
}
// class Cat extends Animal {
class Cat implements  Animal {
    void wakeup() {
        System.out.println("Wakes Up");
    }
    public void sleep() {
        // super.sleep();
        System.out.println("Sleeps for 12 hours");
    }
}
// class Dog extends Animal {
class Dog implements  Animal {
    void makeSound() {
        System.out.println("Barks");
    }
    public void sleep() {
        // super.sleep();
        System.out.println("Sleeps for 8 hours");
    }
}