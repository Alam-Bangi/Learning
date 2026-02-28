class MethodAccessRunner {
    public static void main(String[] args) {
        ExampleClass example = new ExampleClass();
        example.publicMethod();
        example.protectedMethod();
        example.privateMethod();
        example.defaultMethod();
        
    }
}
