import java.util.*;

class MapAllMethods {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();

        int choice;

        do {
            System.out.println("\n~~~~~ MAP INTERFACE MENU ~~~~~");
            System.out.println("1. Add Entry");
            System.out.println("2. Display Map");
            System.out.println("3. putIfAbsent()");
            System.out.println("4. get()");
            System.out.println("5. getOrDefault()");
            System.out.println("6. containsKey()");
            System.out.println("7. containsValue()");
            System.out.println("8. replace()");
            System.out.println("9. Conditional replace()");
            System.out.println("10. remove()");
            System.out.println("11. Iterate using keySet()");
            System.out.println("12. Iterate using entrySet()");
            System.out.println("13. Iterate using forEach()");
            System.out.println("14. Iterate using Iterator");
            System.out.println("15. compute()");
            System.out.println("16. computeIfAbsent()");
            System.out.println("17. computeIfPresent()");
            System.out.println("18. merge()");
            System.out.println("19. Copy Map using putAll()");
            System.out.println("20. size()");
            System.out.println("21. isEmpty()");
            System.out.println("22. clear()");
            System.out.println("23. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter key: ");
                    int key = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter value: ");
                    String value = sc.nextLine();

                    map.put(key, value);
                    System.out.println("Entry Added.");
                    break;

                case 2:
                    System.out.println("Map: " + map);
                    break;

                case 3:
                    System.out.print("Enter key: ");
                    int keyy = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter value: ");
                    String v = sc.nextLine();

                    map.putIfAbsent(keyy, v);
                    System.out.println("Updated Map: " + map);
                    break;

                case 4:
                    System.out.print("Enter key: ");
                    int gKey = sc.nextInt();

                    System.out.println("Value: " + map.get(gKey));
                    break;

                case 5:
                    System.out.print("Enter key: ");
                    int gdKey = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter default value: ");
                    String def = sc.nextLine();

                    System.out.println("Result: "
                            + map.getOrDefault(gdKey, def));
                    break;

                case 6:
                    System.out.print("Enter key: ");
                    int ck = sc.nextInt();

                    System.out.println(map.containsKey(ck));
                    break;

                case 7:
                    sc.nextLine();
                    System.out.print("Enter value: ");
                    String cv = sc.nextLine();

                    System.out.println(map.containsValue(cv));
                    break;

                case 8:
                    System.out.print("Enter key: ");
                    int replaceK = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new value: ");
                    String replaceV = sc.nextLine();

                    map.replace(replaceK, replaceV);
                    System.out.println("Updated Map: " + map);
                    break;

                case 9:
                    System.out.print("Enter key: ");
                    int key1 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter old value: ");
                    String oldVal = sc.nextLine();

                    System.out.print("Enter new value: ");
                    String newVal = sc.nextLine();

                    boolean replaced = map.replace(key1, oldVal, newVal);

                    System.out.println("Replaced: " + replaced);
                    System.out.println("Updated Map: " + map);
                    break;

                case 10:
                    System.out.print("Enter key to remove: ");
                    int rem = sc.nextInt();

                    map.remove(rem);
                    System.out.println("Updated Map: " + map);
                    break;

                case 11:
                    System.out.println("\nUsing keySet():");
                    for (Integer k : map.keySet()) {
                        System.out.println(k + " -> " + map.get(k));
                    }
                    break;

                case 12:
                    System.out.println("\nUsing entrySet():");
                    for (Map.Entry<Integer, String> entry : map.entrySet()) {

                        System.out.println(entry.getKey()
                                + " -> "
                                + entry.getValue());
                    }
                    break;

                case 13:
                    System.out.println("\nUsing forEach():");
                    map.forEach((k, va) -> System.out.println(k + " -> " + va));
                    break;

                case 14:
                    System.out.println("\nUsing Iterator:");

                    Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();

                    while (iterator.hasNext()) {
                        Map.Entry<Integer, String> entry = iterator.next();

                        System.out.println(entry.getKey()
                                + " -> "
                                + entry.getValue());
                    }
                    break;

                case 15:
                    System.out.print("Enter key: ");
                    int compKey = sc.nextInt();
                    sc.nextLine();

                    map.compute(compKey,
                            (k, va) -> (va == null)
                                    ? "ComputedValue"
                                    : va + "_Computed");

                    System.out.println("Updated Map: " + map);
                    break;

                case 16:
                    System.out.print("Enter key: ");
                    int cia = sc.nextInt();

                    map.computeIfAbsent(cia,
                            k -> "ComputeIfAbsent");

                    System.out.println("Updated Map: " + map);
                    break;

                case 17:
                    System.out.print("Enter key: ");
                    int cip = sc.nextInt();

                    map.computeIfPresent(cip,
                            (k, va) -> va + "_Present");

                    System.out.println("Updated Map: " + map);
                    break;

                case 18:
                    System.out.print("Enter key: ");
                    int mk = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter value to merge: ");
                    String mv = sc.nextLine();

                    map.merge(mk, mv,
                            (oldV, newV) -> oldV + "_" + newV);

                    System.out.println("Updated Map: " + map);
                    break;

                case 19:
                    Map<Integer, String> map2 = new HashMap<>();

                    map2.putAll(map);

                    System.out.println("Copied Map: " + map2);
                    System.out.println("map.equals(map2): "
                            + map.equals(map2));
                    break;

                case 20:
                    System.out.println("Size: " + map.size());
                    break;

                case 21:
                    System.out.println("isEmpty(): "
                            + map.isEmpty());
                    break;

                case 22:
                    map.clear();
                    System.out.println("Map Cleared.");
                    break;

                case 23:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 23);

        sc.close();
    }
}