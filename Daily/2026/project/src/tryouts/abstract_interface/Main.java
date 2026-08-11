package tryouts.abstract_interface;

public class Main {
    public static void main(String[] args) {
        BaseEmployee emp = new Developer("Alam", 1012);
        emp.displayType();
        emp.display();
        emp.work();
    }
}
