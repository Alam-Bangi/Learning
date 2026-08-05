/*
11. a) Write a Python program to store roll numbers of student in array who attended training program in random order.
Write function for searching whether particular student attended training program or not,
using Linear search and Sentinel search.
 */
import java.util.Scanner;

public class Assignment11A {

    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    static int sentinelSearch(int[] arr, int key) {
        int n = arr.length;

        int last = arr[n - 1];
        arr[n - 1] = key;

        int i = 0;
        while (arr[i] != key) {
            i++;
        }

        arr[n - 1] = last;

        if (i < n - 1 || arr[n - 1] == key)
            return i;

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] roll = new int[n];

        System.out.println("Enter roll numbers in random order:");
        for (int i = 0; i < n; i++) {
            roll[i] = sc.nextInt();
        }

        System.out.print("Enter roll number to search: ");
        int key = sc.nextInt();

        int result = linearSearch(roll, key);
        if (result != -1){
            System.out.println("Linear Search: Student attended training program.");
        } else {
            System.out.println("Linear Search: Student NOT found.");
        }

        result = sentinelSearch(roll, key);
        if (result != -1) {
            System.out.println("Sentinel Search: Student attended training program.");
        } else {
            System.out.println("Sentinel Search: Student NOT found.");
        }
        sc.close();
    }
}