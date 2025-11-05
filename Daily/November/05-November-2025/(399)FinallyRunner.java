import java.util.Scanner;

class FinallyRunner {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int[] numbers = {12,3,4};
            int number = numbers[5];
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Before Scanner Close");
            if(scanner!=null) {
                scanner.close();
            }
        }
        
    }
}