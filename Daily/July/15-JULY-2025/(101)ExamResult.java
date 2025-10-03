```
// Coding Exercise: Exam Result Checker
// You have been provided with an incomplete Java class named ExamResult. This class has a method isPass(int marks) which needs to be completed.

// The isPass(int marks) method should take an integer value representing the marks obtained by a student in an exam and determine whether the student has passed or failed the exam.

// In this case, a student is considered to have passed the exam if they have scored more than 50 marks. If the student's marks are 50 or less, they are considered to have failed.

// Instructions

// Complete the isPass(int marks) method such that it returns a boolean value indicating whether the student has passed or not. This method should return true if the marks are greater than 50 (indicating the student has passed), and false otherwise (indicating the student has failed).

// Be sure to consider edge cases such as a student scoring exactly 50 marks.

// Remember, the goal is to check if a student has passed or failed based on their marks. Good luck!
```

class ExamResult {
    
    public boolean isPass(int marks) {
        
        // Update Code : If the student's marks are greater than 50, they have passed the exam.
        if (marks > 50) {
    
        return true;
        }
        else {
            return false;
        }
    }
}