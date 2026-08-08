package tryouts.inheritance;

public class HierarchicalInheritance {
    public static void main(String[] args) {

        Developer d = new Developer();
        d.work();
        d.writeCode();

        Tester t = new Tester();
        t.work();
        t.testSoftware();
    }
}