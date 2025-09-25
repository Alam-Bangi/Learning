
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Task2 {
    public static void main(String[] args) {
        // Creating an instance of Student
        Student student = new Student("Alice", 25);
        Student student2 = new Student("Bob", 22);
        Student student3 = new Student("Charlie", 32);
        Student student4 = new Student("David", 49);
        Student student5 = new Student("Eve", 75);

        Set<Student> studentSet = new HashSet<>();
        // Displaying student details
        student.display();
        studentSet.add(student);
        studentSet.add(student2);
        System.out.println("HashSet- ");
        for (Student st : studentSet) {
            st.display();
        }
        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(student);
        linkedHashSet.add(student2);
        System.out.println("LinkedHashSet- ");
        for (Student st : linkedHashSet) {
            st.display();
        }
        TreeSet<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student);
        treeSet1.add(student2);
        treeSet1.add(student3);
        treeSet1.add(student4);
        treeSet1.add(student5);
        // student.getAge().compareTo(student2.getAge());
        System.out.println("TreeSet- ");
        for (Student st : treeSet1) {
            st.display();
        }
        System.out.println("Operations on TreeSet:");
        System.out.println(treeSet1.subSet(student2,true, student4,true));
        treeSet1.
    }
}
class StudentComparator implements Comparator<Student> {
     public int compare(Student student, Student student1) {
         return Integer.compare(student.getAge(), student1.getAge());
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
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
 }