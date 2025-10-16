
import java.math.BigDecimal;

class StudentRunner {
    public static void main(String[] args) {
        int[] marks = {97,98,100};
        Student student = new Student ("Alice", marks);
        
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
    }
}
class Student {
    private String name;
    private int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getNumberOfMarks() {
        return marks.length;
    }
    public int getTotalSumOfMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }
    public int getMaximumMark() {
        int max = Integer.MIN_VALUE;
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }
    public int getMinimumMark() {
        int min = Integer.MAX_VALUE;
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }
    public BigDecimal getAverageMark() {
        int sum = getTotalSumOfMarks();
        int number = getNumberOfMarks();
        if (number == 0) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(sum/number);
    }
}