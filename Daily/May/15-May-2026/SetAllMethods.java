import java.util.*;

class SetAllMethods {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> set = new HashSet<>();

        int choice;

        do {
            System.out.println("\n~~~~~ SET INTERFACE MENU ~~~~~");
            System.out.println("1. Add Element");
            System.out.println("2. Display Set");
            System.out.println("3. Remove Element");
            System.out.println("4. contains()");
            System.out.println("5. size()");
            System.out.println("6. isEmpty()");
            System.out.println("7. Iterate using for-each");
            System.out.println("8. Iterate using Iterator");
            System.out.println("9. addAll()");
            System.out.println("10. removeAll()");
            System.out.println("11. retainAll()");
            System.out.println("12. clear()");
            System.out.println("13. Copy Set");
            System.out.println("14. Convert to Array");
            System.out.println("15. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    String element = sc.nextLine();

                    boolean added = set.add(element);

                    if (added) {
                        System.out.println("Element Added.");
                    } else {
                        System.out.println("Duplicate Element Not Allowed.");
                    }
                    break;

                case 2:
                    System.out.println("Set: " + set);
                    break;

                case 3:
                    System.out.print("Enter element to remove: ");
                    String rem = sc.nextLine();

                    boolean removed = set.remove(rem);

                    if (removed) {
                        System.out.println("Element Removed.");
                    } else {
                        System.out.println("Element Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    String search = sc.nextLine();

                    System.out.println("Contains: "
                            + set.contains(search));
                    break;

                case 5:
                    System.out.println("Size: " + set.size());
                    break;

                case 6:
                    System.out.println("isEmpty(): "
                            + set.isEmpty());
                    break;

                case 7:
                    System.out.println("\nIterating using for-each:");
                    for (String s : set) {
                        System.out.println(s);
                    }
                    break;

                case 8:
                    System.out.println("\nIterating using Iterator:");

                    Iterator<String> iterator = set.iterator();

                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;

                case 9:
                    Set<String> set2 = new HashSet<>();

                    System.out.print("How many elements to add in second set? ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter element: ");
                        set2.add(sc.nextLine());
                    }

                    set.addAll(set2);

                    System.out.println("After addAll(): " + set);
                    break;

                case 10:
                    Set<String> removeSet = new HashSet<>();

                    System.out.print("How many elements to remove? ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < r; i++) {
                        System.out.print("Enter element: ");
                        removeSet.add(sc.nextLine());
                    }

                    set.removeAll(removeSet);

                    System.out.println("After removeAll(): " + set);
                    break;

                case 11:
                    Set<String> retainSet = new HashSet<>();

                    System.out.print("How many elements to retain? ");
                    int rt = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < rt; i++) {
                        System.out.print("Enter element: ");
                        retainSet.add(sc.nextLine());
                    }

                    set.retainAll(retainSet);

                    System.out.println("After retainAll(): " + set);
                    break;

                case 12:
                    set.clear();
                    System.out.println("Set Cleared.");
                    break;

                case 13:
                    Set<String> copiedSet = new HashSet<>(set);

                    System.out.println("Copied Set: "
                            + copiedSet);

                    System.out.println("set.equals(copiedSet): "
                            + set.equals(copiedSet));
                    break;

                case 14:
                    Object[] array = set.toArray();

                    System.out.println("Array Elements:");
                    for (Object obj : array) {
                        System.out.println(obj);
                    }
                    break;

                case 15:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 15);

        sc.close();
    }
}