package tryouts.abstract_interface;

abstract class BaseEmployee implements Employee{
    String name;
    int id;

    BaseEmployee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void display() {
        System.out.println(id + " - " + name);
    }
}
