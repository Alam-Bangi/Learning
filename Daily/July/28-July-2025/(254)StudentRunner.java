
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

class StudentRunner {
    public static void main(String[] args) {
        Student student = new Student ("Alice", 97, 98, 100);
        
        int number = student.getNumberOfMarks();
        System.out.println("number of marks: "+number);

        int sum = student.getTotalSumOfMarks();
        System.out.println("total sum of marks: "+sum);

        int max = student.getMaximumMark();
        System.out.println("maximum mark: "+max);

        int min = student.getMinimumMark();
        System.out.println("minimum mark: "+min);

        BigDecimal average = student.getAverageMark();
        System.out.println("average mark: "+average);

        student.addNewMark(99);
        System.out.println(student);

        student.removeMarkAtIndex(1);

    }
}
class Student {
    private String name;
    private ArrayList<Integer> marks = new ArrayList<Integer>();

    Student(String name, int... marks) {
        this.name = name;

        for(int mark : marks) {
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
    public int getMaximumMark() {
        Collections.max(marks);
    }
    public int getMinimumMark() {
        Collections.min(marks);
    }
    public BigDecimal getAverageMark() {
        int sum = getTotalSumOfMarks();
        int number = getNumberOfMarks();
        if (number == 0) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(sum/number);
    }
    public String toString() {
        return name + marks;
    }
    public void addNewMark(int mark) {
        marks.add(mark);
    }
    public void removeMarkAtIndex(int index) {
        marks.remove(index);
    }
}