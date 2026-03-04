import java.util.List;

class TypeInferencesRunner {
    public static void main(String[] args) {
        List<String> names1 = List.of("A", "B", "C");
        List<String> names2 = List.of("D", "E", "F");
        /* List<List<String>> */
        var names = List.of(names1, names2);
        names.stream().forEach(System.out::println);

        for (var name : names1) {
            System.out.println(name);
        }
    }
}