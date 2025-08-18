
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class FindMax{
    
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.addNumber(95,97,99,100,92,102,105,107,82);
        System.out.println(numbers);
        // System.out.print(numbers.getMax());
    }
}
public class Numbers {
    int[] number= new int[9]; // Length of Array
    
    public Numbers() {
    }
    public void addNumber(int... numbers) {
        
        int i =0;
        for (int n:numbers) {
            if(i<9) {  // Add how many numbers in array
                this.number[i]=n;
            }else {
                return ;
            }
                i++;
        }
    }
    // public int getMax() {
    //     int max = this.number[0];
    //     for (int n:this.number){
    //         if(n>max) {
    //             // System.out.println(n);
    //             // System.out.println(max);
    //             max = n;
    //             // return max;
    //         }
    //     }
    //     return max;
    // }
    // public int getMin() {
    //     int min = this.number[0];
    //     for (int n:this.number) {
    //         if(n<min) {
    //             min = n;
    //         } 
    //     }
    //     return min;
    // }
    public int[] oddNumbers() {
        int[] oddNumber= new int[8];
        int i=0;
        for (int n:this.number) {
            if(i>8) {
                break;
            }
            if (n%2==1) {
                oddNumber[i] = n;
            } else {
                continue;
            }
            i++;
        }
        return oddNumber;
    }
    public int[] evenNumbers() {
        int[] evenNumber= new int[8];
        int i=0;
        for (int n:this.number) {
            if(i>8) {
                break;
            }
            if (n%2==0) {
                evenNumber[i] = n;
            } else {
                continue;
            }
            i++;
        }
        return evenNumber;
    }
    public String toString() {
        StringBuilder mn = new StringBuilder();
        mn.append(Arrays.toString(this.number)).append("\n").append("Maximum number is ").append(this.getMax()).append("\n").append("Minimum number is ").append(this.getMin()).append("\n").append("Odd numbers are ").append(Arrays.toString(this.oddNumbers())).append("\n").append("Even numbers are ").append(Arrays.toString(this.evenNumbers()));
        return mn.toString();
    }
}