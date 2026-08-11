package tryouts;

// Parent class
class Employee {
    void work() {
        System.out.println("Employee is working");
    }
}


// Single Inheritance
class Developer extends Employee {
    void writeCode() {
        System.out.println("Developer writes code");
    }
}


// Multilevel Inheritance
class SeniorDeveloper extends Developer {
    void designSystem() {
        System.out.println("Senior Developer designs system");
    }
}


// Hierarchical Inheritance
class Tester extends Employee {
    void testSoftware() {
        System.out.println("Tester tests software");
    }
}


// Interface for Multiple and Hybrid Inheritance
interface Manager {
    void manageTeam();
}

interface Trainer {
    void trainEmployees();
}


// Multiple Inheritance using Interfaces
class TeamLead implements Manager, Trainer {
    @Override
    public void manageTeam() {
        System.out.println("Team Lead manages the team");
    }

    @Override
    public void trainEmployees() {
        System.out.println("Team Lead trains employees");
    }
}


// Hybrid Inheritance
// SeniorDeveloper inherits Employee -> Developer -> SeniorDeveloper
// and also implements Manager
class TechnicalLead extends SeniorDeveloper implements Manager {

    public void manageTeam() {
        System.out.println("Technical Lead manages the development team");
    }
}


// Main class
public class InheritanceExample {

    public static void main(String[] args) {

        // 1. Single Inheritance
        System.out.println("1. SINGLE INHERITANCE");

        Developer d = new Developer();

        d.work();
        d.writeCode();


        // 2. Multilevel Inheritance
        System.out.println("\n2. MULTILEVEL INHERITANCE");

        SeniorDeveloper sd = new SeniorDeveloper();

        sd.work();
        sd.writeCode();
        sd.designSystem();


        // 3. Hierarchical Inheritance
        System.out.println("\n3. HIERARCHICAL INHERITANCE");

        Tester t = new Tester();

        t.work();
        t.testSoftware();


        // 4. Multiple Inheritance using Interfaces
        System.out.println("\n4. MULTIPLE INHERITANCE");

        TeamLead tl = new TeamLead();

        tl.manageTeam();
        tl.trainEmployees();


        // 5. Hybrid Inheritance
        System.out.println("\n5. HYBRID INHERITANCE");

        TechnicalLead techLead = new TechnicalLead();

        techLead.work();
        techLead.writeCode();
        techLead.designSystem();
        techLead.manageTeam();
    }
}