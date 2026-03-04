import java.util.ArrayList;
import java.util.List;

class CopyOfApiRunner {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");

        List<String> copyOfNames = List.copyOf(names);

        doNotChange(copyOfNames);
        System.out.println(copyOfNames);
    }

    private static void doNotChange(List<String> names) {
        names.add("ShouldNotBeAllowed");
    }
}
