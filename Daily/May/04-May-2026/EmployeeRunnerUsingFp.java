import java.util.*;
import java.util.stream.Collectors;

class EmployeeRunnerUsingFp {

    public static void main(String[] args) {

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("HR", "Arsh", 50000));
        employeeList.add(new Employee("IT", "Razin", 60000));
        employeeList.add(new Employee("IT", "Sami", 45000));

        Set<String> department = new HashSet<>();
        department.add("IT");
        department.add("HR");
        department.add("IT");

        Map<String, Integer> salaryMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));

        System.out.println("Departments:");
        department.forEach(System.out::println);

        System.out.println("\nEmployees:");
        employeeList.forEach(System.out::println);

        System.out.println("\nSalary Map:");
        salaryMap.forEach((name, sal) -> System.out.println(name + " " + sal));

        System.out.println("\nSorted by Salary:");
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .forEach(e -> System.out.println(e.getName() + " " + e.getSalary()));
    }
}

class Employee {
    String department;
    String name;
    int salary;

    Employee(String department, String name, int salary) {
        this.department = department;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String toString() {
        return department + " " + name + " " + salary;
    }
}
