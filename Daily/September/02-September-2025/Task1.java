import java.util.Arrays;
import java.util.Scanner;

class Task1 {
    int[] numbers = new int[5];

    public Task1() {
        this.numbers = new int[]{0};
    }
    public int[] getNumbers() {
        return numbers;
    }
    public void setNumbers() {
        System.out.println("Enter array size: ");
        Scanner scanner = new Scanner(System.in);
        int takeInput = scanner.nextInt();
        this.numbers= new int[takeInput];
        for(int i = 0; i<takeInput; i++) {
            System.out.println("Enter element "+(i+1)+" in array");
            int arrayElement = scanner.nextInt();
            scanner.nextLine();
            this.numbers[i] = arrayElement;
        }
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        System.out.println(task.getNumbers());
        task.setNumbers();
        System.out.println("Your array is "+ Arrays.toString(task.numbers));
    }
}
class Task2 {
    String[] name = new String[7];

    public Task2() {
        this.name = new String[] {"Day"};
    }
    public String[] getname() {
        return name;
    }
    public void setname() {
        System.out.println("Enter the order in which you want name:");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();
        this
    }
}
