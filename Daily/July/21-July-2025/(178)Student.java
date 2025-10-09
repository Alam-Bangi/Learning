```

Coding Exercise: Student Grades A to F based on Marks
You are tasked with implementing the functionality of a Student class which calculates and assigns the student's grade based on the provided marks.

A student's grade is determined by the following criteria:

If the student's marks are less than 0 or greater than 100, the grade should be 'X'.

If the student's marks are greater than or equal to 90, the grade should be 'A'.

If the student's marks are greater than or equal to 80 but less than 90, the grade should be 'B'.

If the student's marks are greater than or  equal to 70 but less than 80, the grade should be 'C'.

If the student's marks are greater than or equal to 60 but less than 70, the grade should be 'D'.

If the student's marks are greater than or equal to 50 but less than 60, the grade should be 'E'.

If the student's marks are less than 50, the grade should be 'F'.

Class Structure

The class Student contains the following:

An instance variable marks of type int.

A constructor that accepts an int parameter to initialize marks.

A method assignGrade() that returns a char, representing the student's grade based on the provided marks.

Here's the skeleton of the class you will work with:

public class student {
    private int marks;
 
    public Student(int marks) {
        // TODO: Assign 'marks' to the instance variable 'this.marks'
    }
 
    public char assignGrade() {
        // TODO: Implement the method which assigns the grade based on marks.
        // If marks are less than 0 or greater than 100, return 'X'
        // If marks are greater than or equal to 90, return 'A'
        // If marks are greater than or equal to 80, return 'B'
        // If marks are greater than or equal to 70, return 'C'
        // If marks are greater than or equal to 60, return 'D'
        // If marks are greater than or equal to 50, return 'E'
        // If marks are less than 50, return 'F'
    }
}
Task

Your task is to implement the Student(int marks) constructor and assignGrade() method in the Student class.

Student(int marks) - This constructor will take one parameter, marks (an integer), and it should assign it to the marks instance variable.

assignGrade() - This method should return a character representing the grade of the student, based on the marks they have received.

If marks are:

less than 0 or greater than 100, return 'X'

greater than or equal to 90, return 'A'

greater than or equal to 80, return 'B'

greater than or equal to 70, return 'C'

greater than or equal to 60, return 'D'

greater than or equal to 50, return 'E'

less than 50, return 'F'

Examples

Here are some examples of how your Student class should behave once implemented:

Student student = new Student(85);
System.out.println(student.assignGrade()); // Should print 'B'
Student student = new Student(101);
System.out.println(student.assignGrade()); // Should print 'X'
In the first example, the student's marks are 85, so the grade is 'B'. In the second example, the student's marks exceed the maximum possible mark of 100, so the method returns 'X' to indicate an invalid mark.

Good luck! Your effective implementation can pass all the examples and additional tests.

```

class Student {
 
    private int marks;
 
    // Constructor for the Student class.
    // It accepts an integer which represents the student's marks,
    // and assigns it to the instance variable 'marks'.
    public Student(int marks) {
        this.marks = marks;
    }
 
    // Method to assign a grade based on the student's marks.
    // It uses conditional statements to determine the grade.
    public char assignGrade() {
        // Check if the marks are out of the expected range (0 to 100).
        // If so, return 'X' to indicate invalid input.
        if (marks < 0 || marks > 100) {
            return 'X';
        }
        // If marks are 90 or above, assign grade 'A'.
        else if (marks >= 90) {
            return 'A';
        }
        // If marks are 80 or above (but less than 90), assign grade 'B'.
        else if (marks >= 80) {
            return 'B';
        }
        // If marks are 70 or above (but less than 80), assign grade 'C'.
        else if (marks >= 70) {
            return 'C';
        }
        // If marks are 60 or above (but less than 70), assign grade 'D'.
        else if (marks >= 60) {
            return 'D';
        }
        // If marks are 50 or above (but less than 60), assign grade 'E'.
        else if (marks >= 50) {
            return 'E';
        }
        // If marks are less than 50, assign grade 'F'.
        else {
            return 'F';
        }
    }
}