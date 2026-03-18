class SuperRevision {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Saff", "Software Engineer", 'A');
        employee1.setAge(28);
        employee1.setAddress("Camp, India");
        System.out.println(employee1);

        // Person person = new Person("ALAM", 23, "Swargate, Pune");
        Employee employee = new Employee("ALAM", "Software Engineer", 'A');
        employee.setAge(23);
        employee.setAddress("Swargate, Pune");
        System.out.println(employee);

        // Person person2 = new Person("Bob", 30, "Baner, Pune");
        Employee employee2 = new Employee("Bob");
        employee2.setPosition("Manager");
        employee2.setGrade('B');
        System.out.println(employee2);
    }
}

class Person {
    String name;
    int age;
    String address;

    Person() {
    }

    Person(String name) {
        this.name = name;
    }

    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Person name = " + name + ", age = " + age + ", address = " + address;
    }
}

class Employee extends Person {
    String position;
    char grade;

    Employee(String name) {
        super(name);
    }

    Employee(String name, String position, char grade) {
        super(name);
        this.position = position;
        this.grade = grade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String toString() {
        if (age == 0 && address == null) {
            return "Please set age and address for employee " + name;
        }
        return super.toString() + ", position = " + position + ", grade = " + grade;
    }
}