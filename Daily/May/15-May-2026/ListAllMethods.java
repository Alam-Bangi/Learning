import java.util.*;

class ListAllMethods {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n~~~~~ LIST INTERFACE MENU ~~~~~");
            System.out.println("1. Add Element");
            System.out.println("2. Display List");
            System.out.println("3. Add Element at Index");
            System.out.println("4. addAll()");
            System.out.println("5. get()");
            System.out.println("6. set()");
            System.out.println("7. remove(index)");
            System.out.println("8. remove(object)");
            System.out.println("9. contains()");
            System.out.println("10. indexOf()");
            System.out.println("11. lastIndexOf()");
            System.out.println("12. Iterate using for loop");
            System.out.println("13. Iterate using enhanced for loop");
            System.out.println("14. Iterate using Iterator");
            System.out.println("15. Iterate using ListIterator");
            System.out.println("16. forEach()");
            System.out.println("17. sort()");
            System.out.println("18. reverse()");
            System.out.println("19. subList()");
            System.out.println("20. replaceAll()");
            System.out.println("21. removeIf()");
            System.out.println("22. clear()");
            System.out.println("23. size()");
            System.out.println("24. isEmpty()");
            System.out.println("25. Copy List using addAll()");
            System.out.println("26. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    String element = sc.nextLine();

                    list.add(element);

                    System.out.println("Element Added.");
                    break;

                case 2:
                    System.out.println("List: " + list);
                    break;

                case 3:
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter element: ");
                    String ele = sc.nextLine();

                    list.add(index, ele);

                    System.out.println("Updated List: " + list);
                    break;

                case 4:
                    List<String> temp = new ArrayList<>();

                    System.out.print("How many elements to add? ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter element: ");
                        temp.add(sc.nextLine());
                    }

                    list.addAll(temp);

                    System.out.println("Updated List: " + list);
                    break;

                case 5:
                    System.out.print("Enter index: ");
                    int getIndex = sc.nextInt();

                    System.out.println("Element: " + list.get(getIndex));
                    break;

                case 6:
                    System.out.print("Enter index: ");
                    int setIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new value: ");
                    String newValue = sc.nextLine();

                    list.set(setIndex, newValue);

                    System.out.println("Updated List: " + list);
                    break;

                case 7:
                    System.out.print("Enter index to remove: ");
                    int remIndex = sc.nextInt();

                    list.remove(remIndex);

                    System.out.println("Updated List: " + list);
                    break;

                case 8:
                    sc.nextLine();

                    System.out.print("Enter object to remove: ");
                    String remObj = sc.nextLine();

                    list.remove(remObj);

                    System.out.println("Updated List: " + list);
                    break;

                case 9:
                    System.out.print("Enter element: ");
                    String search = sc.nextLine();

                    System.out.println(list.contains(search));
                    break;

                case 10:
                    System.out.print("Enter element: ");
                    String ind = sc.nextLine();

                    System.out.println("Index: " + list.indexOf(ind));
                    break;

                case 11:
                    System.out.print("Enter element: ");
                    String lind = sc.nextLine();

                    System.out.println("Last Index: " + list.lastIndexOf(lind));
                    break;

                case 12:
                    System.out.println("\nUsing for loop:");

                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + " -> " + list.get(i));
                    }
                    break;

                case 13:
                    System.out.println("\nUsing enhanced for loop:");

                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;

                case 14:
                    System.out.println("\nUsing Iterator:");

                    Iterator<String> iterator = list.iterator();

                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;

                case 15:
                    System.out.println("\nUsing ListIterator:");

                    ListIterator<String> listIterator = list.listIterator();

                    while (listIterator.hasNext()) {
                        System.out.println(listIterator.next());
                    }
                    break;

                case 16:
                    System.out.println("\nUsing forEach():");

                    list.forEach(item -> System.out.println(item));
                    break;

                case 17:
                    Collections.sort(list);

                    System.out.println("Sorted List: " + list);
                    break;

                case 18:
                    Collections.reverse(list);

                    System.out.println("Reversed List: " + list);
                    break;

                case 19:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();

                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();

                    System.out.println("SubList: " + list.subList(start, end));
                    break;

                case 20:
                    list.replaceAll(str -> str.toUpperCase());

                    System.out.println("Updated List: " + list);
                    break;

                case 21:
                    System.out.print("Enter starting letter to remove: ");
                    char ch = sc.next().charAt(0);

                    list.removeIf(str -> str.startsWith(String.valueOf(ch)));

                    System.out.println("Updated List: " + list);
                    break;

                case 22:
                    list.clear();

                    System.out.println("List Cleared.");
                    break;

                case 23:
                    System.out.println("Size: " + list.size());
                    break;

                case 24:
                    System.out.println("isEmpty(): " + list.isEmpty());
                    break;

                case 25:
                    List<String> copyList = new ArrayList<>();

                    copyList.addAll(list);

                    System.out.println("Copied List: " + copyList);
                    System.out.println("list.equals(copyList): "
                            + list.equals(copyList));
                    break;

                case 26:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 26);

        sc.close();
    }
}