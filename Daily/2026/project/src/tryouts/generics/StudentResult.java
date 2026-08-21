package tryouts.generics;

// 2. <T, U> - Multiple type parameters
class StudentResult<T, U> {

    private T student;
    private U marks;

    StudentResult(T student, U marks) {
        this.student = student;
        this.marks = marks;
    }

    public T getStudent() {
        return student;
    }

    public U getMarks() {
        return marks;
    }
}