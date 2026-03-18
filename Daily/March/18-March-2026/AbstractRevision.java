class AbstractRevision {
    public static void main(String[] args) {
        ConcreteClass obj = new ConcreteClass();
        obj.display();
    }
}

abstract class AbstractClass {
    abstract void display();
}

abstract class AbstractClass2 {
    void display() {
        System.out.println("This is a concrete method in an abstract class.");
    }
}

class ConcreteClass extends AbstractClass2 {

}
