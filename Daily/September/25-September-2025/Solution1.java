
import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public static void main(String[] args) {
        // Creating an instance of Student
        Student student = new Student("Alice", 25);
        Student student2 = new Student("Bob", 22);
        Student student3 = new Student("Charlie", 32);
        Student student4 = new Student("David", 49);
        Student student5 = new Student("Eve", 75);

        Set<Student> studentSet = new HashSet<>();
        student.display();
        studentSet.addAll(Set.of(student, student2, student3, student4, student5));
        System.out.println("HashSet- ");
        for (Student st : studentSet) {
            st.display();
        }
        studentSet.contains(student2);
        studentSet.remove(student3);
        System.out.println("After removing student3:");
        for (Student st : studentSet) {
            st.display();
        }
        System.out.println("HashCode: " + studentSet.hashCode());
        studentSet.equals(studentSet);
        System.out.println("Does the set contain student4? " + studentSet.contains(student4));
        System.out.println("Is the set empty? " + studentSet.isEmpty());
        studentSet.removeAll(Set.of(student, student2));
        System.out.println("After removing all, size: " + studentSet.size());
        // studentSet.notifyAll();
        // studentSet.removeIf(student.getAge() > 60);
        // studentSet.wait(1,5);
        studentSet.clear();
        System.out.println("After clearing the set, size: " + studentSet.size());
    }
}
class Student implements Comparable<Student>{
    String name;
    int age;

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