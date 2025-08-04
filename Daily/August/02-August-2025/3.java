import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
             
            for (int j =0; j<n; j++){
                System.out.print((a+(result(b, j)))+" ");
                
            }
            System.out.println();
        }
        
        in.close();
    }
    public static int result(int number, int raise) {
        int sum = 0;
        if (raise==0) {
            return number;
        } else {
            for (int j=0; j<=raise; j++) {
            sum += (power(2, j) * number);
            }
        }
        return sum;
    }
    public static int power(int number, int raise) {
        int answer = 1;
        for (int i=1; i<=raise; i++) {
            answer *= number ;
        }
        return answer;
    }
}