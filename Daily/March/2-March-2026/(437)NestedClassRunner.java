class NestedClassRunner {

    int i;

    class InnerClass {
        public void method() {
            i = 5;
        }
    }

    static class StaticNestedClass {

    }

    public static void main(String[] args) {
        // InnnerClass innerClass = new InnnerClass();
        StaticNestedClass staticNestedClass = new StaticNestedClass();
        NestedClassRunner nestedClassRunner = new NestedClassRunner();
        InnerClass innerClass = nestedClassRunner.new InnerClass();
    }
}

class Person {

}
