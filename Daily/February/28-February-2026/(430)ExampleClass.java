public class ExampleClass {
    public static void main(String[] args) {
        ExampleClass example = new ExampleClass();
        example.publicMethod();
        example.protectedMethod();
        example.privateMethod();
        example.defaultMethod();
    }
    public void publicMethod() {}
    protected void protectedMethod() {}
    private void privateMethod() {}
    void defaultMethod() {} 
}