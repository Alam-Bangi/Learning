
class MoreGenerics {
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] strArray = { "ABC, XYZ" };
        Double[] dArray = { 1.1, 2.2, 3.3 };

        printArray(intArray);
        System.out.println(" ");
        printArray(strArray);
        System.out.println(" ");
        printArray(dArray);
    }

    static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
    }
}
