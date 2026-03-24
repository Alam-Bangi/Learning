class GenericsExample {
    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        intContainer.set(10);
        System.out.println(intContainer.get());

        Container<String> strContainer = new Container<>();
        strContainer.set("ABC");
        System.out.println(strContainer.get());
    }
}

class Container<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}