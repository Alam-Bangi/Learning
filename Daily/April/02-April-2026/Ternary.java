class Ternary {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 85);
        Student student2 = new Student("Bob", 25);
        Student student3 = new Student("Charlie", 58);

        System.out.println(student1.name + " is " + student1.getResult());
        System.out.println(student2.name + " is " + student2.getResult());
        System.out.println(student3.name + " is " + student3.getResult());
    }
}

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getResult() {
        return (marks >= 28) ? "Pass" : "Fail";
    }
}
