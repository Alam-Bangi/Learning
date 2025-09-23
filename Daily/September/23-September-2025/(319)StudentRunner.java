import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentRunner {
    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Alice", 1), new Student("Bob", 20), new Student("Charlie", 13));
        ArrayList<Student> studentsAl = new ArrayList<>(students);
        System.out.println(studentsAl);
        Collections.sort(studentsAl);
        System.out.println("DescendingStudentComparator " + studentsAl);
        Collections.sort(studentsAl, new AscendingStudentComparator());
        System.out.println("AscendingStudentComparator " + studentsAl);
        studentsAl.sort(new AscendingStudentComparator());
        System.out.println("AscendingStudentComparator " + studentsAl);
    }
}
class AscendingStudentComparator implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getId(), student2.getId());
    }
}
class Student implements Comparable<Student> {
    private String name;
    private int id;
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student name: ").append(name).append(", ID: ").append(id);
        return sb.toString();
    }
    public int compareTo(Student that) {
        return Integer.compare(that.id,this.id);
    }
}