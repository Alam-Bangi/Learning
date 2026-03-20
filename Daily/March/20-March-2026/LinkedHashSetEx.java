import java.util.LinkedHashSet;

class LinkedHashSetEx {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(70);
        linkedHashSet.add(30);
        linkedHashSet.add(50);
        linkedHashSet.add(10);
        linkedHashSet.add(90);

        System.out.println("Elements in the LinkedHashSet: " + linkedHashSet);

    }
}
