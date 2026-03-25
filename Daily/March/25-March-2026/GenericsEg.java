import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GenericsEg {
    static <X> X doubleValue(X value) {
        return value;
    }

    static <X extends List> void duplicate(X list) {
        list.addAll(list);
    }

    public static void main(String[] args) {

        String value1 = doubleValue("ABC");
        Integer number1 = doubleValue(Integer.valueOf(12));
        LinkedList list1 = doubleValue(new LinkedList<>());

        LinkedList<Integer> numbers = new LinkedList<>(List.of(2, 1, 3));
        duplicate(numbers);
        System.out.println(numbers);

        Generics<Integer> intList = new Generics<>();
        System.out.println("Integer List: ");
        intList.addElement(100);
        intList.addElement(12);

        intList.removeElement(12);

        intList.getElements();

        // Generics<String> strList = new Generics();
        // strList.addElement("ABC");
        // strList.addElement("XYZ");

        // strList.removeElement("ABC");

        // strList.getElements();
    }
}

class Generics<T extends Number> {
    T value;
    ArrayList<T> list = new ArrayList<>();

    public void addElement(T value) {
        list.add(value);
    }

    public void removeElement(T value) {
        list.remove(value);
    }

    public void getElements() {
        System.out.print(list);
    }
}