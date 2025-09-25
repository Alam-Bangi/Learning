
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Task1 {
    public static void main(String[] args) {
        // Creating an instance of Student
        Student student = new Student("Alice", 25);
        Student student2 = new Student("Bob", 22);

        Set<Student> studentSet = new HashSet<>();
        student.display();
        studentSet.add(student);
        studentSet.add(student2);
        System.out.println("HashSet- ");
        for (Student st : studentSet) {
            st.display();
        }
        
        Set<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(student);
        linkedHashSet.add(student2);
        System.out.println("LinkedHashSet- ");
        for (Student st : linkedHashSet) {
            st.display();
        }
        
        Set<Student> treeSet1 = new TreeSet<>(new StudentComparator());
        // Set<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student);
        treeSet1.add(student2);
        // student.getAge().compareTo(student2.getAge());
        System.out.println("TreeSet with Comparator- ");
        // System.out.println(Integer.compare(student.getAge(), student2.getAge()));
        for (Student st : treeSet1) {
            st.display();
        }
    }
}
class StudentComparator implements Comparator<Student> {
    public int compare(Student student, Student student1) {
        return student.getName().compareTo(student1.getName());
    }
}
class Student implements Comparable<Student>{
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
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
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}