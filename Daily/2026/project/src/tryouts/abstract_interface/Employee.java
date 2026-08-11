package tryouts.abstract_interface;

public interface Employee {
    void work();

    default void displayType() {
        System.out.println("Employee");
    }
}
