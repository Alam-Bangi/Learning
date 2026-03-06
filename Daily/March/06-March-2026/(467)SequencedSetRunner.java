import java.util.LinkedHashSet;
import java.util.List;

class SequencedSetRunner {
    public static void main(String[] args) {
        var courses = List.of("Spring", "Spring Boot", "AWS", "Azure"); 
        var courseDetailsSet = new LinkedHashSet<>(courses);

        System.out.println("First Element:: "+courseDetailsSet.getFirst()); System.out.println("Last Element:: "+courseDetailsSet.getLast()); 

        // System.out.println("Order:: "+courseDetailsSet);

        System.out.println("Adding new elements");
        courseDetailsSet.addFirst("Spring Security"); 
        courseDetailsSet.addLast("Spring AI");
        System.out.println("Order:: "+courseDetailsSet); 
        System.out.println("Reversed:: "+courseDetailsSet.reversed());
    }
}
