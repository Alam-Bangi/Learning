class StudentRunner {
    public static void main(String[] args) {
        // Student student = new Student();
        // student.setName("Alice");
        // student.setEmail("aliceinwonderland@gmail.com");
        // student.setPhoneNumber("1234567890");
        // student.setCollege("Wonderland University");
        // student.setYear(2);

        Person person = new Person();
        person.setName("Alice");
        person.setEmail("123@gmail.com");
        person.setPhoneNumber("1234567890");
        String value = person.toString();
        System.out.println(value);
        System.out.println(person);
    }
}
class Person extends Object {
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
        return name + "#" + email + "#" + phoneNumber;
    }
}
class Student extends Person {
    private String college;
    private int year;

    public Student(String name, String college) {
        super(name);
        this.college = college;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}


