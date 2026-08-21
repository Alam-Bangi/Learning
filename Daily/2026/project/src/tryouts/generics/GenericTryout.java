package tryouts.generics;
import java.io.Serializable;
import java.util.*;

public class GenericTryout {
    public static void main(String[] args) {

        // <T> - Type parameter
        System.out.println("<T> - Type parameter");
        Storage<String> names = new Storage<>();
        names.add("Amaan");
        names.add("Razin");

        String name = names.get(0);
        System.out.println(name);

        // <T, U> - Multiple type parameters
        System.out.println("\nMultiple type parameters");
        StudentResult<String, Integer> result = new StudentResult<>("Amaan", 90);
        StudentResult<String, Integer> result1 = new StudentResult<>("Alam", 75);

        System.out.println(result.getStudent() + " scored " + result.getMarks());
        System.out.println(result1.getStudent() + " scored " + result1.getMarks());

        // <?> - Unbounded wildcard
        System.out.println("\n<?> - Unbounded wildcard");
        List<String> students = List.of("Amaan", "Razin");
        printList(students);

        // <? extends Number> - Upper bound
        System.out.println("\n<? extends Number> - Upper bound");
        List<Integer> marks = List.of(80, 90, 70);
        printNumbers(marks);

        // <? super Integer> - Lower bound
        System.out.println("\n<? super Integer> - Lower bound");
        List<Number> numbers = new ArrayList<>();
        addMarks(numbers);
        System.out.println(numbers);

        // <T extends Number> - Bounded type
        System.out.println("\n<T extends Number> - Bounded type");
        Calculator<Integer> calculator = new Calculator<>();
        System.out.println(calculator.square(5));

        // <T extends A & B> - Multiple bounds
        System.out.println("\n<T extends A & B> - Multiple bounds");
        Student student = new Student(101, "Amaan");
        StudentService<Student> service = new StudentService<>();
        service.process(student);

        // List<String> - Parameterized type
        System.out.println("\nList<String> - Parameterized type");
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("SQL");
        System.out.println(subjects);

        // List<List<String>> - Nested generics
        System.out.println("\nList<List<String>> - Nested generics");
        List<List<String>> studentSubjects = new ArrayList<>();
        studentSubjects.add(List.of("Java", "SQL"));
        studentSubjects.add(List.of("Python", "Math"));
        System.out.println(studentSubjects);

        // List - Raw type (AVOID)
        List rawList = new ArrayList();
        // No type safety!
        rawList.add("Amaan");
        rawList.add(100);

        // new ArrayList<>() - Diamond operator
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        test();
    }

    // <?> - Can accept any List
    static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    // <? extends Number> - Number or subclasses
    static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }

    // <? super Integer> - Integer or its parent types
    static void addMarks(List<? super Integer> numbers) {
        numbers.add(90);
        numbers.add(80);
    }

    static void test() {
        List list = new ArrayList();
        List list1 = new LinkedList();
        System.out.println(list instanceof List);
        System.out.println(list instanceof Serializable);
        System.out.println(list instanceof ArrayList);
        System.out.println(list1 instanceof List);
        System.out.println(list1 instanceof LinkedList);
    }
}
