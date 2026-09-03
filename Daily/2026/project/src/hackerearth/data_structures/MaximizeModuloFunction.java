package hackerearth.data_structures;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximizeModuloFunction {
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        ArrayList<Integer> results = new ArrayList<>();
        while (testCases-- > 0) {
            int strLength = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();


            String firstCut = s.substring(1);
            int result1 = Integer.parseInt(firstCut) % k;

            String lastCut = s.substring(0, strLength - 1);
            int result2 = Integer.parseInt(lastCut) % k;

            System.out.println(result1 + " " + result2);
            int ans = Math.max(result1, result2);
            results.add(ans);
        }
        for(int r : results) {
            System.out.println(r);
        }
        sc.close();
    }
}
