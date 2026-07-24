package random;

public class ForLoop {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        for(int num : numbers) {
            System.out.println(num);
        }
        String test = "test";
        for(char c : test.toCharArray()) {
            System.out.println(c);
        }
    }
}
