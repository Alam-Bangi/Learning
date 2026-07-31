package random;

import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 25;
        int n1 = 0;
        int n2 = 1;
        int sum = 0;
        System.out.print(n1 +", "+ n2);

        for(int i = 0; i < n; i++) {
            sum = n1+n2;
            n1 = n2;
            n2 = sum;
            System.out.print(", "+sum);
        }
    }
}
