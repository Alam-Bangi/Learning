class Task1 {
    public static void main(String[] args) {
        // Task task = new Task();
        // task.method();
        Abc abc = new Abc();
        abc.method();
        abc.method1();
    }
}
abstract class Task2 {
    public abstract void method2();
    void method(){
        System.out.println("1");
    }
}
abstract class Task3 {
    void method(){
        System.out.println("2");
    }
}
class Task extends Task3{
    void method() {
        super.method();
    }
}

interface Interface1 {
    abstract void method();
    default void method1() {
        System.out.println("Default");
    }
}
interface Interface2{
    abstract void method();
    abstract  void method1() ;
    // default void method1() {
    //     System.out.println("Default1");
    // }
}
class Abc implements Interface2, Interface1 {
    public void method() {
        int number = 1+2;
        System.out.println(number);
    }
    public void method1() {
        System.out.println("I am from Abc");
    }
}
interface ClassA {
    abstract void function1();
    abstract void function2();

}
class Xyz implements ClassA {
    public void function1() {
        
    }
    public void function2() {

    }
    public void function3() {

    }
}