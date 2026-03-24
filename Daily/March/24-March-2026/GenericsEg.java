import java.util.ArrayList;

class GenericsEg {
    public static void main(String[] args) {

        Generics<Integer> intList = new Generics();
        System.out.println("Integer List: ");
        intList.addElement(100);
        intList.addElement(12);

        intList.removeElement(12);

        intList.getElements();

        Generics<String> strList = new Generics();
        strList.addElement("ABC");
        strList.addElement("XYZ");

        strList.removeElement("ABC");

        strList.getElements();
    }
}

class Generics<T> {
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