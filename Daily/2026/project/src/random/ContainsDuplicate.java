package random;

import java.util.ArrayList;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] numbers = {1,3,5,3,6};
        ArrayList<Integer> distinct = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++) {
            if(distinct.contains(numbers[i])) {
                System.out.println(numbers[i]);
            } else {
                distinct.add(numbers[i]);
            }
        }
        System.out.println(distinct);
    }
}
