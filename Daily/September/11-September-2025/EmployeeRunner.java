
import java.math.BigDecimal;

class EmployeeRunner {
    public static void main(String[] args) {

        // Person person = new Person();
        // person.setName("Amaan");
        // person.setEmail("abc123@gmail.com");
        // System.out.println(person);

        Employee employee = new Employee("Alam","Data Analyst");
        // employee.setName("Alam");
        employee.setEmail("bangialam12@gmail.com");
        employee.setPhoneNumber("1234567890");
        employee.setEmployeeGrade('A');
        // employee.setTitle("Data Analyst");
        System.out.println(employee);
    }
}
class Person {
    private String name;
    private String email;
    private String phoneNumber;

    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String toString() {
        StringBuilder ps = new StringBuilder();
        ps.append("Name - ").append(name).append("\n").append("Email - ").append(email).append("\n").append("Mobile Number - ").append(phoneNumber);
        return ps.toString();
    }
}
class Employee extends Person {
    String title;
    String employerName;
    char employeeGrade;
    BigDecimal salary;

    public Employee(String name , String title) {
        super(name);
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getEmployerName() {
        return employerName;
    }
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    public char getEmployeeGrade() {
        return employeeGrade;
    }
    public void setEmployeeGrade(char employeeGrade) {
        this.employeeGrade = employeeGrade;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public String toString() {
        StringBuilder emp = new StringBuilder();
        emp.append(super.toString()).append("\n").append("Job title - ").append(title).append("\n").append("Grade - ").append(employeeGrade).append("\n");
        return emp.toString();
    }
}
