import java.math.BigDecimal;

public class StudentRunner {
    
    public static void main(String[] args) {
        int[] marks = {99,98,90};
        Student student = new Student("Ranga", marks);
        int number = student.getNumberOfMarks();
        System.out.println("number of marks: "+number);
        int sum = student.getTotalSumOfMarks();
        System.out.println("sum of marks: "+sum);
        int maximumMark = student.getMaximumMarks();
        System.out.println("maximum marks: "+maximumMark);
        int minimumMark = student.getMinimumMarks();
        System.out.println("minimum marks: "+minimumMark);
        BigDecimal averageMark = student.getAverageMarks();
        System.out.println("average marks: "+averageMark);
    }
}

public class Student{
    private String name;
    private int[] marks;
    
    public Student(String name, int[] marks) {
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

    public int getMaximumMarks() {
        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }

    public int getMinimumMarks() {
        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }
    
    public BigDecimal getAverageMarks() {
        int sum= getTotalSumOfMarks();
        int number= getNumberOfMarks();
        BigDecimal average = new BigDecimal(sum/number);
        return average;
    }
}
