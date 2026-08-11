package tryouts.abstract_interface;

public class Developer extends BaseEmployee{
    Developer(String name, int id) {
        super(name,id);
    }

    @Override
    public void work() {
        System.out.println("Writing code");
    }
}
