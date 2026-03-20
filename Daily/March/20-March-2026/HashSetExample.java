import java.util.HashSet;

class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("Dog");
        hashSet.add("Cat");
        hashSet.add("Bird");
        hashSet.add("Dog");

        System.out.println("Elements in the HashSet: " + hashSet);

        String elementToCheck = "Cat";
        if (hashSet.contains(elementToCheck)) {
            System.out.println(elementToCheck + " is present in the HashSet.");
        } else {
            System.out.println(elementToCheck + " is not present in the HashSet.");
        }

        hashSet.remove("Bird");
        System.out.println("Elements in the HashSet after removal: " + hashSet);
    }
}
