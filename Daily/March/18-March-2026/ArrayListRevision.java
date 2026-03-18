import java.util.*;

class ArrayListRevision {
    public static void main(String[] args) {
        ArrayList<Byte> byteNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("For Byte ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            byteNumbers.add(scanner.nextByte());
        }
        System.out.println("Byte ArrayList: " + byteNumbers);

        ArrayList<Short> shortNumbers = new ArrayList<>();
        System.out.println("For Short ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            shortNumbers.add(scanner.nextShort());
        }
        System.out.println("Short ArrayList: " + shortNumbers);

        ArrayList<Integer> intNumbers = new ArrayList<>();
        System.out.println("For Integer ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            intNumbers.add(scanner.nextInt());
        }
        System.out.println("Integer ArrayList: " + intNumbers);

        ArrayList<Long> longNumbers = new ArrayList<>();
        System.out.println("For Long ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            longNumbers.add(scanner.nextLong());
        }
        System.out.println("Long ArrayList: " + longNumbers);

        ArrayList<Float> floatNumbers = new ArrayList<>();
        System.out.println("For Float ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            floatNumbers.add(scanner.nextFloat());
        }
        System.out.println("Float ArrayList: " + floatNumbers);

        ArrayList<Double> doubleNumbers = new ArrayList<>();
        System.out.println("For Double ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            doubleNumbers.add(scanner.nextDouble());
        }
        System.out.println("Double ArrayList: " + doubleNumbers);

        ArrayList<Character> charArray = new ArrayList<>();
        System.out.println("For Character ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a character at index " + (i + 1) + ": ");
            charArray.add(scanner.next().charAt(0));
        }
        System.out.println("Character ArrayList: " + charArray);

        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("For String ArrayList:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a string at index " + (i + 1) + ": ");
            stringArrayList.add(scanner.next());
        }
        System.out.println("String ArrayList: " + stringArrayList);

        scanner.close();
    }
}
