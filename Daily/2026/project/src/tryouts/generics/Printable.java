package tryouts.generics;

// 4. Multiple bounds: <T extends A & B>
interface Printable {
    void print();
}

interface Identifiable {
    int getId();
}

class Human {
    void act() {
        System.out.println("Acting");
    }
}
interface Person {
    default void acting() {
        System.out.println("Person class");
    }
}

class Student extends Human implements Person, Printable, Identifiable {

    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print() {
        System.out.println("Student: " + name);
    }

    public int getId() {
        return id;
    }
}

class StudentService<T extends Human & Person & Printable & Identifiable> {

    public void process(T student) {
        System.out.println("ID: " + student.getId());
        student.print();
        student.act();
        student.acting();
    }
}
