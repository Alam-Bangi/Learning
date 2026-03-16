import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

class ArrayListRevision {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        Student student = new Student("Alice", 85, 90, 78, 92, 88);

        // int numberOfMarks = student.getNumberOfMarks();
        // System.out.println("Number of marks for " + student.name + ": " +
        // numberOfMarks);

        // int sumOfMarks = student.getTotalSumOfMarks();
        // System.out.println("Sum of marks for " + student.name + ": " + sumOfMarks);

        // int minimumMark = student.getMinimumMark();
        // System.out.println("Minimum mark for " + student.name + ": " + minimumMark);

        // int maximumMark = student.getMaximumMark();
        // System.out.println("Maximum mark for " + student.name + ": " + maximumMark);

        // BigDecimal averageMark = student.getAverageMark();
        // System.out.println("Average mark for " + student.name + ": " + averageMark);

        System.out.println(student);

        student.addNewMark(95);
        System.out.println("After adding a new mark: " + student);

        student.removeMarkAtIndex(2);
        System.out.println("After removing mark at index 2: " + student);
    }
}

class Student {
    String name;
    ArrayList<Integer> marks;

    Student(String name, int... marks) {
        this.name = name;
        this.marks = new ArrayList<>();
        for (int mark : marks) {
            this.marks.add(mark);
        }
    }

    public int getNumberOfMarks() {
        return marks.size();
    }

    public int getTotalSumOfMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    public int getMinimumMark() {
        return Collections.min(marks);
    }

    public int getMaximumMark() {
        return Collections.max(marks);
    }

    public BigDecimal getAverageMark() {
        int sum = getTotalSumOfMarks();
        int count = getNumberOfMarks();
        return new BigDecimal(sum).divide(new BigDecimal(count), 3, RoundingMode.UP);
    }

    public void addNewMark(int mark) {
        marks.add(mark);
    }

    public void removeMarkAtIndex(int index) {
        marks.remove(index);
    }

    public String toString() {
        return "Student{name=" + name + ", marks=" + marks + "}";
    }
}
