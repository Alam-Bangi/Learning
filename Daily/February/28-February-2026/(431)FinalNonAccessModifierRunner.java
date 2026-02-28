class FinalNonAccessModifierRunner {
    public static void main(String[] args) {

    }
}

final class FinalClass {

}
// class SubClass extends FinalClass {
// }

class SomeClass {
    final public void doSomething() {
        System.out.println("Doing something...");
    }
}

class ExtendingClass extends SomeClass {
    // @Override
    // public void doSomething() {
    // System.out.println("Doing something else...");
    // }
}