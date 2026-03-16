import java.math.BigDecimal;
import java.math.RoundingMode;

class ArrayRevision {
    public static void main(String[] args) {
        int[] marks = { 85, 90, 78, 92, 88 };
        Student student = new Student("Alice", marks);

        int numberOfMarks = student.getNumberOfMarks();
        System.out.println("Number of marks for " + student.name + ": " + numberOfMarks);

        int sumOfMarks = student.getTotalSumOfMarks();
        System.out.println("Sum of marks for " + student.name + ": " + sumOfMarks);

        int minimumMark = student.getMinimumMark();
        System.out.println("Minimum mark for " + student.name + ": " + minimumMark);

        int maximumMark = student.getMaximumMark();
        System.out.println("Maximum mark for " + student.name + ": " + maximumMark);
    }
}

class Student {
    String name;
    int[] marks;

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

    public int getMinimumMark() {
        int min = Integer.MAX_VALUE;
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }

    public int getMaximumMark() {
        int max = 0;
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }

    public BigDecimal getAverageMark() {
        int sum = getTotalSumOfMarks();
        int count = getNumberOfMarks();
        return new BigDecimal(sum).divide(new BigDecimal(count), 3, RoundingMode.UP);
    }
}