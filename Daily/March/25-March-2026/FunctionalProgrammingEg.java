import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class FunctionalProgrammingEg {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(11, 24, 35, 42, 58));
        printElements(intList);

        System.out.println(" ");
        System.out.print("Even Numbers: ");
        intList.stream().filter(e -> e % 2 == 0).forEach(s -> System.out.print(s + " "));

        System.out.println(" ");
        System.out.print("Even Numbers after dividing by 2: ");
        intList.stream().filter(e -> e % 2 == 0).map(e -> e / 2).forEach(s -> System.out.print(s + " "));

        System.out.println(" ");
        List<Integer> intList1 = new ArrayList<>(List.of(11, 42, 58, 35, 24));
        System.out.print("After Making Odd Numbers Even: ");
        intList1.stream().sorted().filter(e -> e % 2 == 1).map(e -> e + 1).forEach(e -> System.out.print(e + " "));

        System.out.println(" ");
        List<Integer> oddNumbers = intList1.stream().filter(e -> e % 2 == 1).collect(Collectors.toList());
        System.out.print("OddNumbers Using collect method: " + oddNumbers);

        System.out.println(" ");
        List<String> strList = new LinkedList<>(List.of("ABC", "XYZ", "PQR"));
        printElements(strList);
    }

    static <T> void printElements(List<T> list) {
        list.stream().forEach(e -> System.out.print(e + " "));
    }
}
