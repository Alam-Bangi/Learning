package random;

class Department {
    String name;

    public Department(String name) {
        this.name = name;
    }

    public Department(Department other) {
        this.name = other.name;
    }
}

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(Employee other) {
        this.name = other.name;
        this.department = new Department(other.department);
    }
}

public class Main {
    public static void main(String[] args) {
        Department dep1 = new Department("Engineering");
        Employee emp1 = new Employee("John", dep1);

        Employee emp2 = new Employee(emp1);

        emp2.department.name = "Research & Development";

        System.out.println("emp1 name : "+ emp1.name + ", emp1 department: " + emp1.department.name);
        System.out.println("emp2 name : "+ emp2.name + ", emp2 department: " + emp2.department.name);
    }
}
