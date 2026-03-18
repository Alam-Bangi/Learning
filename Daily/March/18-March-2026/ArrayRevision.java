import java.util.*;

class ArrayRevision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte[] byteNumbers = new byte[5];
        System.out.println("For Byte array:");
        for (int i = 0; i < byteNumbers.length; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            byteNumbers[i] = scanner.nextByte();
        }
        System.out.println("Byte array: " + Arrays.toString(byteNumbers));

        short[] shortNumbers = new short[5];
        System.out.println("For Short array:");
        for (int i = 0; i < shortNumbers.length; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            shortNumbers[i] = scanner.nextShort();
        }
        System.out.println("Short array: " + Arrays.toString(shortNumbers));

        int[] intNumbers = new int[5];
        System.out.println("For Integer array:");
        for (int i = 0; i < intNumbers.length; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            intNumbers[i] = scanner.nextInt();
        }
        System.out.println("Integer array: " + Arrays.toString(intNumbers));

        long[] longNumbers = new long[5];
        System.out.println("For Long array:");
        for (int i = 0; i < longNumbers.length; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            longNumbers[i] = scanner.nextLong();
        }
        System.out.println("Long array: " + Arrays.toString(longNumbers));

        float[] floatNumbers = new float[5];
        System.out.println("For Float array:");
        for (int i = 0; i < floatNumbers.length; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            floatNumbers[i] = scanner.nextFloat();
        }
        System.out.println("Float array: " + Arrays.toString(floatNumbers));

        double[] doubleNumbers = new double[5];
        System.out.println("For Double array:");
        for (int i = 0; i < doubleNumbers.length; i++) {
            System.out.print("Enter a number at index " + (i + 1) + ": ");
            doubleNumbers[i] = scanner.nextDouble();
        }
        System.out.println("Double array: " + Arrays.toString(doubleNumbers));

        char[] charArray = new char[5];
        System.out.println("For Character array:");
        for (int i = 0; i < charArray.length; i++) {
            System.out.print("Enter a character at index " + (i + 1) + ": ");
            charArray[i] = scanner.next().charAt(0);
        }
        System.out.println("Character array: " + Arrays.toString(charArray));

        String[] stringArray = new String[5];
        System.out.println("For String array:");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print("Enter a string at index " + (i + 1) + ": ");
            stringArray[i] = scanner.next();
        }
        System.out.println("String array: " + Arrays.toString(stringArray));

        scanner.close();
    }
}
