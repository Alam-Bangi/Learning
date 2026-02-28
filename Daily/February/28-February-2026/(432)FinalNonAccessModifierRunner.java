class FinalNonAccessModifierRunner {
    public static void main(String[] args) {
        final int i;
        i = 9;

        // i = 8;
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

    public void doSomethingElse(final int arg) {
        // arg = 6;
    }
}

class ExtendingClass extends SomeClass {
    // @Override
    // public void doSomething() {
    // System.out.println("Doing something else...");
    // }
}