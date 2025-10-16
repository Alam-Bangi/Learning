class StudentRunner {
    public static void main(String[] args) {
        int[] marks = {85, 90, 78};
        Student student = new Student ("Alice", marks);
        int number = student.getNumberOfMarks();
        System.out.println("number of marks: "+number);
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
}