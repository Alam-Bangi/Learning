
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
    int[] number= new int[5];
    
    public Numbers() {
    }
    public void addNumber(int... numbers) {
        
        int i =0;
        for (int n:numbers) {
            if(i<5) {
                this.number[i]=n;
            }else {
                return ;
            }
                i++;
        }
    }
    public int getMax() {
        int max = this.number[0];
        for (int n:this.number){
            if(n>max) {
                // System.out.println(n);
                // System.out.println(max);
                max = n;
                // return max;
            }
        }
        return max;
    }
    public String toString() {
        StringBuilder mn = new StringBuilder();
        mn.append(Arrays.toString(this.number)).append("\n").append("Maximum number is ").append(this.getMax());
        return mn.toString();
    }
}