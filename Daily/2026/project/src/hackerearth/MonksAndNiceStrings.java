package hackerearth;

import java.util.*;

class MonksAndNiceStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String[] s = new String[n];
        int j = 0;
        s[0] = "A";
        for(int i = 1 ; i < (n+1) ; i++) {
            String str = "";
            str = scan.next();
            for(j = i - 1 ; j >= 0 ; j--) {
                if(s[j].compareTo(str) >= 0) {
                    s[j+1] = s[j];
                }
                else {
                    break;
                }
            }
            System.out.println(j);
            s[j+1] = str;
        }
    }
}

