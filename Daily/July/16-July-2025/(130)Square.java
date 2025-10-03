```
// Coding Exercise: Create a Square class
// In this exercise, you're tasked to implement a class called Square in Java. This class is responsible for modeling a geometric shape - a square.

// A Square object has one private instance variable, side (of type int), which denotes the length of a side of the square.

// The Square class has a constructor that takes an integer argument. This argument should be used to initialize the side attribute.

// This class also includes two methods:

// calculateArea(): This method calculates and returns the area of the square. The area of a square is given by the formula: side * side. However, in the real world, a square cannot have a side length of zero or less. So, if side is less than or equal to zero, this method should return -1 to indicate an invalid value.

// calculatePerimeter(): This method calculates and returns the perimeter of the square. The perimeter of a square is given by the formula: 4 * side. Similar to the above, if side is less than or equal to zero, this method should return -1 to indicate an invalid value.

// Your task is to complete the implementation of the constructor and these two methods.

// Instructions

// Implement the Square constructor. This constructor should take an integer argument and initialize the side attribute with the value of this argument.

// Implement the calculateArea() method. If the side attribute is less than or equal to zero, return -1. Otherwise, calculate and return the area of the square using the formula: side * side.

// Implement the calculatePerimeter() method. If the side attribute is less than or equal to zero, return -1. Otherwise, calculate and return the perimeter of the square using the formula: 4 * side.

// Example

// Let's consider the following examples:

// In the first example, we create a Square object with side equal to 5. Therefore, the calculateArea() method returns 25 (5 * 5) and the calculatePerimeter() method returns 20 (4 * 5).

// Square square = new Square(5);
// System.out.println(square.calculateArea()); // prints: 25
// System.out.println(square.calculatePerimeter()); // prints: 20
// In the second example, we create a Square object with side equal to 0. Therefore, both the calculateArea() and calculatePerimeter() methods return -1 as they represent invalid values. This is because a square cannot have a side length of zero.

// Square squareWithZeroSide = new Square(0);
// System.out.println(squareWithZeroSide.calculateArea()); // prints: -1
// System.out.println(squareWithZeroSide.calculatePerimeter()); // prints: -1
// In the third example, we create a Square object with a non-positive side (-5). Therefore, both the calculateArea() and calculatePerimeter() methods return -1 as they represent invalid values. This is because a square cannot have a side length less than zero.

// Square squareWithNonPositiveSide = new Square(-5);
// System.out.println(squareWithNonPositiveSide.calculateArea()); // prints: -1
// System.out.println(squareWithNonPositiveSide.calculatePerimeter()); // prints: -1

```


class Square {

    private int side;

    public Square(int side) {
        // TODO: Initialize side with the passed value
        this.side=side;
    }

    public int calculateArea() {
        // TODO: Calculate and return the area of the square
        if (this.side <=0) {
        return -1;
    } 
    return side *side;
    }

    public int calculatePerimeter() {
        // TODO: Calculate and return the perimeter of the square
        if (this.side <=0) {
        return -1;
        } 
        return 4*side;
    }
}


