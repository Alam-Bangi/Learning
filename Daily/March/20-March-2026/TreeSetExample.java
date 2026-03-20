import java.util.TreeSet;

class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(70);
        treeSet.add(30);
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(90);

        System.out.println("Elements in the TreeSet: " + treeSet);

        System.out.println("Floor of 47: " + treeSet.floor(47));
        System.out.println("Ceiling of 64: " + treeSet.ceiling(64));
        System.out.println("Higher than 34: " + treeSet.higher(34));
        System.out.println("Lower than 50: " + treeSet.lower(50));
        System.out.println("Subset from 30 to 70: " + treeSet.subSet(30, true, 70, true));
        System.out.println("Headset up to 50: " + treeSet.headSet(50));
        System.out.println("Tailset from 50: " + treeSet.tailSet(50, true));

    }
}
