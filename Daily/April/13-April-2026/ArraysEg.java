import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

class ArraysEg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte[] byteArray = new byte[5];
        System.out.println("Enter 5 byte values:");
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = sc.nextByte();
        }
        System.out.println("Byte Array: " + Arrays.toString(byteArray));

        short[] shortArray = new short[5];
        System.out.println("Enter 5 short values:");
        for (int i = 0; i < shortArray.length; i++) {
            shortArray[i] = sc.nextShort();
        }
        System.out.println("Short Array: " + Arrays.toString(shortArray));

        int[] intArray = new int[5];
        System.out.println("Enter 5 int values:");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = sc.nextInt();
        }
        System.out.println("Int Array: " + Arrays.toString(intArray));

        long[] longArray = new long[5];
        System.out.println("Enter 5 long values:");
        for (int i = 0; i < longArray.length; i++) {
            longArray[i] = sc.nextLong();
        }
        System.out.println("Long Array: " + Arrays.toString(longArray));

        float[] floatArray = new float[5];
        System.out.println("Enter 5 float values:");
        for (int i = 0; i < floatArray.length; i++) {
            floatArray[i] = sc.nextFloat();
        }
        System.out.println("Float Array: " + Arrays.toString(floatArray));

        double[] doubleArray = new double[5];
        System.out.println("Enter 5 double values:");
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = sc.nextDouble();
        }
        System.out.println("Double Array: " + Arrays.toString(doubleArray));

        char[] charArray = new char[5];
        System.out.println("Enter 5 char values:");
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = sc.next().charAt(0);
        }
        System.out.println("Char Array: " + Arrays.toString(charArray));

        boolean[] booleanArray = new boolean[5];
        System.out.println("Enter 5 boolean values (true/false):");
        for (int i = 0; i < booleanArray.length; i++) {
            booleanArray[i] = sc.nextBoolean();
        }
        System.out.println("Boolean Array: " + Arrays.toString(booleanArray));

        String[] stringArray = new String[5];
        System.out.println("Enter 5 string values:");
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = sc.nextLine();
        }
        System.out.println("String Array: " + Arrays.toString(stringArray));

        BigDecimal[] bigDecimalArray = new BigDecimal[5];
        System.out.println("Enter 5 BigDecimal values:");
        for (int i = 0; i < bigDecimalArray.length; i++) {
            bigDecimalArray[i] = sc.nextBigDecimal();
        }
        System.out.println("BigDecimal Array: " + Arrays.toString(bigDecimalArray));

        Student[] students = new Student[3];
        students[0] = new Student("Alice", 20);
        students[1] = new Student("Bob", 22);
        students[2] = new Student("Charlie", 21);
        System.out.println(Arrays.toString(students));

        sc.close();
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "(Name- " + name + ", Age- " + age + ")";
    }
}