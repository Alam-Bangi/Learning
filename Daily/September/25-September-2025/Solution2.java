
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class Solution2 {
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

        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(Set.of(student, student2, student3, student4, student5));
        linkedHashSet.addFirst(student3);
        linkedHashSet.addLast(student);
        System.out.println("LinkedHashSet after adding elements at first and last- ");
        for (Student st : linkedHashSet) {
            st.display();
        }
        System.out.println("Operations on LinkedHashSet:");
        System.out.println("First Element: " + linkedHashSet.getFirst());
        System.out.println("Last Element: " + linkedHashSet.getLast());
        System.out.println("Removing First Element: " + linkedHashSet.removeFirst());
        System.out.println("Removing Last Element: " + linkedHashSet.removeLast());
        System.out.println("Does the set contain student2? " + linkedHashSet.contains(student2));
        System.out.println("Is the set empty? " + linkedHashSet.isEmpty());
        System.out.println("Size of the set: " + linkedHashSet.size());
        System.out.println(linkedHashSet.equals(studentSet));
        System.out.println("HashCode: " + linkedHashSet.hashCode());
        linkedHashSet.removeAll(Set.of(student, student2));
        System.out.println("After removing all, size: " + linkedHashSet.size());
        linkedHashSet.clear();
        System.out.println("After clearing the set, size: " + linkedHashSet.size());

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