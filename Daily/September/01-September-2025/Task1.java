import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    private int[] numbers= new int[5];
    public Task1() {
        this.numbers = new int[]{0};
        // String name = "Abrar";
    }
    public int[] getNumbers() {
        return numbers;
    }
    public void setNumbers() {
        System.out.println("Enter the array size: ");
        Scanner scanner = new Scanner(System.in);
        int inputFromUser= scanner.nextInt();
        System.out.println(inputFromUser);
        this.numbers= new int[inputFromUser];
        System.out.println(Arrays.toString(this.numbers));
        for (int i = 0; i<inputFromUser;i++) {
            System.out.println("Enter elements in array: ");
            int arrayElements = scanner.nextInt();
            scanner.nextLine();
            this.numbers[i] = arrayElements;
        }
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        System.out.println(task);
        System.out.println(Arrays.toString(task.getNumbers()));
        task.setNumbers();
        System.out.println(Arrays.toString(task.numbers));
    }
}
