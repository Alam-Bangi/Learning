/*
It is decided  that  weekly greetings are  to  be  furnished  to  wish the  students  having their 
birthdays in that week. The consolidated sorted list with desired categorical information 
is to  be  provided  to  the  authority.  Write  a  Python  program  to  store  students  PRNs with 
date  and  month  of  birth.  Let  List_A  and  List_B  be  the  two  list  for  two  SE  Computer 
divisions.  Lists  are  sorted  on  date  and  month.  Merge  these  two  lists  into  third  list List_SE_Comp_DOB 
resulting in sorted information about Date of Birth of SE Computer students 
*/

import java.util.Arrays;

class Assignment6 {
    public static void main(String[] args) {
        Student[] listA = {
                new Student("PRN001", 15, 1),
                new Student("PRN002", 22, 11),
                new Student("PRN003", 10, 5)
        };

        Student[] listB = {
                new Student("PRN004", 5, 3),
                new Student("PRN005", 18, 9),
                new Student("PRN006", 30, 7)
        };

        Arrays.sort(listA);
        Arrays.sort(listB);
        Student[] mergedList = mergeLists(listA, listB);

        System.out.println("Merged List of Students (Sorted by Date of Birth/Month):");

        for (Student student : mergedList) {
            System.out.println("PRN: " + student.getPrn() + ", DOB: " + student.getDateOfBirth() + "/"
                    + student.getMonthOfBirth());
        }
    }

    private static Student[] mergeLists(Student[] listA, Student[] listB) {
        int sizeA = listA.length;
        int sizeB = listB.length;
        Student[] mergedList = new Student[sizeA + sizeB];

        int listAindex = 0, listBindex = 0, mergedListindex = 0;

        while (listAindex < sizeA && listBindex < sizeB) {
            if (listA[listAindex].compareTo(listB[listBindex]) <= 0) {
                mergedList[mergedListindex++] = listA[listAindex++];
            } else {
                mergedList[mergedListindex++] = listB[listBindex++];
            }
        }

        while (listAindex < sizeA) {
            mergedList[mergedListindex++] = listA[listAindex++];
        }

        while (listBindex < sizeB) {
            mergedList[mergedListindex++] = listB[listBindex++];
        }

        return mergedList;
    }
}

class Student implements Comparable<Student> {
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

    @Override
    public int compareTo(Student other) {
        if (this.monthOfBirth != other.monthOfBirth) {
            return Integer.compare(this.monthOfBirth, other.monthOfBirth);
        } else {
            return Integer.compare(this.dateOfBirth, other.dateOfBirth);
        }
    }
}