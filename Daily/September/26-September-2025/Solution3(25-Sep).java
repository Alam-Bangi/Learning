
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution3 {
    public static void main(String[] args) {
        // Creating an instance of Student
        Student student = new Student("Alice", 25);
        Student student2 = new Student("Bob", 22);
        Student student3 = new Student("Xyz", 75);
        Student student4 = new Student("David", 49);
        Student student5 = new Student("Eve", 75);
        Student student6 = new Student("Frank", 22);
        Student student7 = new Student("Grace", 32);

        Set<Student> studentSet = new HashSet<>();
        student.display();
        studentSet.addAll(Set.of(student3, student4, student5, student6, student7));

        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.addAll(Set.of(student, student2, student3, student4, student5));

        // student.getAge().compareTo(student2.getAge());
        System.out.println();
        System.out.println("TreeSet- ");
        for (Student st : treeSet) {
            st.display();
        }
        System.out.println();
        System.out.println("Operations on TreeSet:");
        System.out.println(treeSet.subSet(student2,true, student4,true));
        System.out.println(treeSet.ceiling(student));
        System.out.println(treeSet.floor(student4));
        System.out.println(treeSet.higher(student2));
        System.out.println(treeSet.lower(student3));
        System.out.println("First Element: " + treeSet.first());
        System.out.println("Last Element: " + treeSet.last());
        System.out.println("Size of the set: " + treeSet.size());
        System.out.println("Does the set contain student2? " + treeSet.contains(student2));
        System.out.println("Is the set empty? " + treeSet.isEmpty());
        System.out.println("HashCode: " + treeSet.hashCode());
        // System.out.println(treeSet.removeAll(Set.of(student2, student4)));
        System.out.println("After removing selected students, size: " + treeSet.size());
        System.out.println("Does TreeSet equals HashSet? " + treeSet.equals(studentSet));
        System.out.println("Does TreeSet contains all of data in HashSet? " + treeSet.containsAll(studentSet));  
        System.out.println("Tree Set: ");
        for (Student st : treeSet) {
            st.display();
        }
        System.out.println();
        System.out.println(" Hash Set: ");
        for (Student st : studentSet) {
            st.display();
        }
        System.out.println();
        System.out.println("Retaining all data from hashset " + treeSet.retainAll(studentSet));
        for (Student st : treeSet) {
            st.display();
        }
        System.out.println();
        System.out.println("HashCode: " + treeSet.hashCode());
        System.out.println("All data before student4" + treeSet.headSet(student4));
        System.out.println("All data after student2" + treeSet.tailSet(student2));
        System.out.println("Descending Set: " + treeSet.descendingSet());
        System.out.println("Removing First Element: " + treeSet.pollFirst());
        System.out.println("Removing Last Element: " + treeSet.pollLast());
        treeSet.clear();
        System.out.println("After clearing the set, size: " + treeSet.size());
        treeSet.addAll(Set.of(student, student2, student3, student4, student5));
        System.out.println("After adding all data from hashset");
        for (Student st : treeSet) {
            st.display();
        }
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
        System.out.print("Name: " + name + ", Age: " + age +" ");
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
 }