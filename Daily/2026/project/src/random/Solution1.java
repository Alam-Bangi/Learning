/*
Sum of 2 large numbers. Given 2 numbers as string
Numbers are very large and cant be stored as long,int
Find sum of 2numbers
*/

package random;

public class Solution1 {
    public static void main(String[] args) {
        String no1 = "3333311111111111";
        String no2 = "44422222221111";
//        String no1 = "11";
//        String no2 = "1";
        StringBuilder ans = new StringBuilder();

        int maxSize = no1.length() > no2.length() ? no1.length() : no2.length();
        System.out.println("max" + maxSize);
        int pointer = 1;
        int carry = 0;
        while(pointer <= maxSize) {
            int element1 = 0;
            int element2 = 0;
            if(no1.length()>=pointer){
                element1 = Character.getNumericValue(no1.charAt(no1.length()-pointer));
            }
            if(no2.length()>=pointer){
                element2 = Character.getNumericValue(no2.charAt(no2.length()-pointer));
            }
            int sum = element1 + element2 + carry;

            if(sum > 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            ans.append(sum % 10);
            pointer++;
        }
        System.out.println(ans.reverse().toString());
    }
}
