```

Coding Exercise: Is Leap Year
You are given a class leapYearChecker with a method isLeapYear(int year). Your task is to complete the implementation of the method to determine if a given year is a leap year.

The rules are a little tricky. Read them carefully.

A year is a leap year in the Gregorian calendar if:

It is divisible by 4 (AND)

It is NOT divisible by 100 (except when it is divisible by 400)

Not Divisible by 4 - NOT Leap Year (2041)

Divisible by 4 and NOT divisible by 100 - Leap Year (2048)

Divisible by 4 and divisible by 100 - Additional check needed

Divisible by 4, divisible by 100, divisible by 400 - Leap Year (2000, 2400)

Divisible by 4, divisible by 100, NOT divisible by 400 - NOT Leap Year (2100, 2200, 2300)

Instructions

Implement the isLeapYear method to return true if the year is a leap year and false otherwise.

You need to account for the edge case where the year is less than 1. For such a case, the method should return false.

public class leapYearChecker {
    public boolean isLeapYear(int year) {
       // Implement your code here
    }
}
Please ensure your code passes all the test cases, including edge cases, and adheres to the above guidelines.

```

class LeapYearChecker {
    public boolean isLeapYear(int year) {
        if (year<1) {
       return false;
    }
    if (year%4 !=0){
        return false;
    }
    if (year%100 !=0) {
        return true;
    }
    if (year%400 !=0) {
        return false;
    }
    return true;
    
    }
}