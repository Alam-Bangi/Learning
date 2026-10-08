/*
b) Write a Python program to store names and mobile numbers of your friends in sorted
order on names. Search your friend from list using Fibonacci search. Insert friend if not
present in phonebook.
*/
import java.util.Scanner;

public class Assignment12b {
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

        System.out.print("\nEnter name to search: ");
        String key = sc.nextLine().trim();
        
        int pos = fibonacciSearch(key);

        if (pos != -1) {
            System.out.println("Found: " + name[pos] + " : " + phone[pos]);
        } else {
            System.out.print("Not found. Enter mobile number for " + key + ": ");
            insert(key, sc.nextLine().trim());
            display();
        }

        sc.close();
    }

    static void insert(String newName, String newPhone) {
        for (int i = 0; i < n; i++) {
            if (name[i].equalsIgnoreCase(newName)) {
                System.out.println("Contact already exists!");
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
    }

    static int fibonacciSearch(String key) {
        if (n == 0) return -1;

        int fibM2 = 0;
        int fibM1 = 1;
        int fibM = fibM2 + fibM1;

        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);
            int cmp = name[i].compareToIgnoreCase(key);

            if (cmp < 0) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (cmp > 0) {
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i;
            }
        }

        if (fibM1 == 1 && offset + 1 < n && name[offset + 1].equalsIgnoreCase(key)) {
            return offset + 1;
        }

        return -1;
    }

    static void display() {
        System.out.println("\nPhonebook:");
        for (int i = 0; i < n; i++) {
            System.out.println(name[i] + " : " + phone[i]);
        }
    }
}
