package hackerearth.data_structures;

import java.util.ArrayList;
import java.util.Scanner;

public class UniqueSubarrays {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        ArrayList<Integer> answers = new ArrayList<>();
        while(testCases > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] != n) {
                    sum += arr[i] + n;
                } else {
                    sum += arr[i];
                }
            }
            answers.add(sum);
            testCases--;
        }
        for(int ans : answers) {
            System.out.println(ans);
        }
    }
}
