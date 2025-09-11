class StudentRunner {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Amaan");
        person.setEmail("abc123@gmail.com");
        System.out.println(person);
        
        Student student = new Student();
        student.setName("Alam");
        student.setEmail("bangialam12@gmail.com");
        System.out.println(student);
    }
}
class Person {
    private String name;
    private String email;
    private String phoneNumber;

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
class Student extends Person {
    private String college;
    private int year;

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
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("College - ").append(college).append("\n").append("Year - ").append(year);
        return st.toString();
    }
}