// Demonstrates Java modifiers:
// volatile, synchronized, transient, native,
// strictfp, sealed, non-sealed

// ---------------- MAIN CLASS ----------------
public class Modifiers {

    public static void main(String[] args) {

        // Sealed / non-sealed example
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();

        v1.showType();
        v2.showType();

        // strictfp + volatile + synchronized + transient
        Calculator calc = new Calculator();

        calc.increment();
        calc.increment();

        double result = calc.divide(10.0, 3.0);
        System.out.println("Division Result: " + result);

        calc.displayTransient();

        // native method cannot run unless linked with JNI library
        // calc.showNativeMessage();
    }
}

// ---------------- SEALED CLASS ----------------
sealed class Vehicle permits Car, Bike {
    public void showType() {
        System.out.println("This is a vehicle");
    }
}

// ---------------- NON-SEALED CLASS ----------------
non-sealed class Car extends Vehicle {
    public void drive() {
        System.out.println("Car is driving");
    }
}

// ---------------- FINAL SEALED CHILD ----------------
final class Bike extends Vehicle {
    public void ride() {
        System.out.println("Bike is riding");
    }
}

// ---------------- STRICTFP CLASS ----------------
strictfp class Calculator {

    // volatile variable
    private volatile int counter = 0;

    // transient variable
    transient String temporaryData = "SessionData";

    // synchronized method
    public synchronized void increment() {
        counter++;
        System.out.println("Counter: " + counter);
    }

    // strictfp method
    public strictfp double divide(double a, double b) {
        return a / b;
    }

    // native method declaration
    // (implemented in another language like C/C++)
    public native void showNativeMessage();

    public void displayTransient() {
        System.out.println("Transient Data: " + temporaryData);
    }
}
