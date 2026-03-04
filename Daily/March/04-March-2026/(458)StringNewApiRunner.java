class StringNewApiRunner {
    public static void main(String[] args) {
        System.out.println("".isBlank());
        System.out.println(" ABC ".strip().replace(" ", "!"));
        System.out.println(" ABC ".stripLeading().replace(" ", "!"));
        System.out.println(" ABC ".stripTrailing().replace(" ", "!"));
        "Line1\nLine2\nLine3".lines().forEach(System.out::println);

        // System.out.println("AAALAM".transform(a -> a.replace("AAA", "A")));
        System.out.println("My name is %s. My age is %d.".formatted("Alam", 23));

        SampleClass sampleClass = new SampleClass();
        String str = null;
        System.out.println(sampleClass.str.isBlank());
        // Exception in thread "main" java.lang.NullPointerException: Cannot invoke
        // "String.isBlank()" because "<local2>" is null
        // at StringNewApiRunner.main((458)StringNewApiRunner.java:14)

    }
}

class SampleClass {
    String str = null;
}