/*
It is decided  that  weekly greetings are  to  be  furnished  to  wish the  students  having their 
birthdays in that week. The consolidated sorted list with desired categorical information 
is to  be  provided  to  the  authority.  Write  a  Python  program  to  store  students  PRNs with 
date  and  month  of  birth.  Let  List_A  and  List_B  be  the  two  list  for  two  SE  Computer 
divisions.  Lists  are  sorted  on  date  and  month.  Merge  these  two  lists  into  third  list 
“List_SE_Comp_DOB” resulting in sorted information about Date of Birth of SE Computer 
students 
*/

public class Assignment6 {
    public static void main(String[] args) {
        Student[] listA = {
                new Student("PRN001", 15, 3),
                new Student("PRN002", 22, 5),
                new Student("PRN003", 10, 7)
        };

        Student[] listB = {
                new Student("PRN004", 5, 2),
                new Student("PRN005", 18, 4),
                new Student("PRN006", 30, 6)
        };

        Student[] mergedList = mergeLists(listA, listB);

        System.out.println("Merged List of Students (Sorted by Date of Birth):");

    }

    public static Student[] mergeLists(Student[] listA, Student[] listB) {
        int sizeA = listA.length;
        int sizeB = listB.length;
        Student[] mergedList = new Student[sizeA + sizeB];

        int i = 0, j = 0, k = 0;

        while (i < sizeA && j < sizeB) {

        }
    }

class Student {
    private String prn;
    private int dateOfBirth;
    private int monthOfBirth;

    public Student(String prn, int dateOfBirth, int monthOfBirth) {
        this.prn = prn;
        this.dateOfBirth = dateOfBirth;
        this.monthOfBirth = monthOfBirth;
    }
    public String getPrn() {
        return prn;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }
}