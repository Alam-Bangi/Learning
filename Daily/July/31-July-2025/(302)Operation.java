/**

Java Coding Exercise - Arithmetic Operations
In this exercise, we want to create a mathematical operations application. This application should be able to perform the basic operations of addition, subtraction, and division.

You are provided with an Operation interface with a perform method, which should take two integers as arguments and return an integer.

The goal is to implement three classes, Add, Subtract, and Divide, which implement the Operation interface and provide their specific implementations of the perform method.

However, there's a catch: when performing division, if the divisor is zero, your program should return -1 to indicate an error.

Input Format

The input of the perform method will be two integer values, x and y.

Output Format

The output of the perform method should be an integer which is the result of performing the respective operation on x and y.

Instructions

Complete the Add class by implementing the perform method. This method should return the result of adding x and y.

Complete the Subtract class by implementing the perform method. This method should return the result of subtracting y from x.

Complete the Divide class by implementing the perform method. This method should return the result of dividing x by y. But before performing the division, check if y is zero. If y is zero, return -1.
 */

interface Operation {
    int perform(int x, int y);
}
 
class Add implements Operation {
    @Override
    public int perform(int x, int y) {
        return x + y;
    }
}
 
class Subtract implements Operation {
    @Override
    public int perform(int x, int y) {
        return x - y;
    }
}
 
class Divide implements Operation {
    @Override
    public int perform(int x, int y) {
        if (y == 0) {
            return -1;
        }
        return x / y;
    }
}