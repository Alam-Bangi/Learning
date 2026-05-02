import java.util.*;

class EmployeeRunner {

    public static void main(String[] args) {

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Amit", 50000));
        employeeList.add(new Employee(117, "Neha", 60000));
        employeeList.add(new Employee(113, "Ravi", 45000));

        Set<String> department = new HashSet<>();
        department.add("IT");
        department.add("HR");
        department.add("IT");

        Map<String, Integer> salaryMap = new HashMap<>();
        salaryMap.put("Amit", 50000);
        salaryMap.put("Neha", 60000);
        salaryMap.put("Ravi", 45000);

        TreeMap<Integer, String> sortedSalary = new TreeMap<>();
        for (Employee e : employeeList) {
            sortedSalary.put(e.salary, e.name);
        }

        System.out.println("Employees:");
        for (Employee e : employeeList) {
            System.out.println(e);
        }

        System.out.println("\nDepartments:");
        for (String d : department) {
            System.out.println(d);
        }

        System.out.println("\nSalary Map:");
        for (String name : salaryMap.keySet()) {
            System.out.println(name + " - " + salaryMap.get(name));
        }

        System.out.println("\nSorted by Salary:");
        for (Integer sal : sortedSalary.keySet()) {
            System.out.println(sal + " - " + sortedSalary.get(sal));
        }
    }
}

class Employee {
    int id;
    String name;
    int salary;

    Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + salary;
    }
}
