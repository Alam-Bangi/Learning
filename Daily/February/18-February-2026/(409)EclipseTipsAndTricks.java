import java.math.BigDecimal;

class EclipseTipsAndTricks {
    public static void main(String[] args) throws InterruptedException {
        DummyForTest dt = new DummyForTest();
        dt.doSomething();

        BigDecimal bd = new BigDecimal(25);
        Thread.sleep(extracted());
    }

    private static int extracted() {
        return 1000 * 60 * 60 * 24;
    }
}

class Test implements Comparable<String> {
    public int compareTo(String arg0) {
        return 0;
    }
}

class DummyForTest {
    public void doSomething() {
        System.out.println("Doing something");
    }
}