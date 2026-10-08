/*
a) Write a Python program to store names and mobile numbers of your friends in sorted
order on names. Search your friend from list using binary search (recursive and nonrecursive). Insert friend if not present in phonebook
*/
import java.util.Scanner;

public class Assignment12a {
    static String[] name = new String[50];
    static String[] phone = new String[50];
    static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // System.out.print("Enter number of friends: ");
        // int total = sc.nextInt();
        // sc.nextLine(); 

        // for (int i = 0; i < total; i++) {
        //     System.out.print("Enter name: ");
        //     String name = sc.nextLine();

        //     System.out.print("Enter mobile number: ");
        //     String phone = sc.nextLine();

        //     insert(name, phone);
        // }

        insert("Rahul", "9876543210");
        insert("Amit", "9123456780");
        insert("Sneha", "9988776655");
        insert("Priya", "9090909090");
        insert("Karan", "8888888888");

        display();

        System.out.print("\nEnter name to search (non-recursive): ");
        String key = sc.nextLine();
        int pos = binarySearch(key);

        if (pos != -1) {
            System.out.println("Found: " + name[pos] + " : " + phone[pos]);
        } else {
            System.out.println("Friend not found.");
        }


        System.out.print("\nEnter name to search (recursive): ");
        key = sc.nextLine();
        pos = recursiveSearch(key, 0, n - 1);

        if (pos != -1) {
            System.out.println("Found: " + name[pos] + " : " + phone[pos]);
        } else {
            System.out.println("Friend not found.");
        }

        sc.close();
    }

    static void insert(String newName, String newPhone) {
        for (int i = 0; i < n; i++) {
            if (name[i].equalsIgnoreCase(newName)) {
                System.out.println("Friend already exists!");
                return;
            }
        }

        int i = n - 1;
        while (i >= 0 && name[i].compareToIgnoreCase(newName) > 0) {
            name[i + 1] = name[i];
            phone[i + 1] = phone[i];
            i--;
        }

        name[i + 1] = newName;
        phone[i + 1] = newPhone;
        n++;

        System.out.println("Friend inserted.");
    }

    static int binarySearch(String key) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = name[mid].compareToIgnoreCase(key);

            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static int recursiveSearch(String key, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        int cmp = name[mid].compareToIgnoreCase(key);

        if (cmp == 0) return mid;
        if (cmp < 0) return recursiveSearch(key, mid + 1, high);
        return recursiveSearch(key, low, mid - 1);
    }

    static void display() {
        System.out.println("\nPhonebook:");
        for (int i = 0; i < n; i++) {
            System.out.println(name[i] + " : " + phone[i]);
        }
    }
}