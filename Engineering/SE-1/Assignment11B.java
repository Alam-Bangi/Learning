/*
11. b) Write a Python program to store roll numbers of student array who attended training program in sorted order.
Write function for searching whether particular student attended training program or not,
using Binary search and Fibonacci search
*/
import java.util.Scanner;

public class Assignment11B {

    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] roll = new int[n];
        System.out.println("Enter roll numbers in sorted order:");
        for (int i = 0; i < n; i++) {
            roll[i] = sc.nextInt();
        }

        System.out.print("Enter roll number to search: ");
        int key = sc.nextInt();

        int result = binarySearch(roll, key);
        if (result != -1) {
            System.out.println("Binary Search: Student attended training program.");
        } else {
            System.out.println("Binary Search: Student NOT found.");
        }
        sc.close();
    }
}