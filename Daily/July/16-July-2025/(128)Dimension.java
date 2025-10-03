```
// Coding Exercise: Inches to Object (Feet, Inches)
// In this problem, you have to complete the implementation of a Dimension class in Java that represents measurements in feet and inches.

// Here is the skeleton of the Dimension class:

// public class Dimension {
//     private int feet;
//     private int inches;
    
//     public Dimension(int inches) {
//         // TODO: Convert the total inches into feet and inches. One foot is 12 inches.
//         // Store the feet and inches in their respective instance variables.
//     }
    
//     public int getFeet() {
//         // TODO: Return the value of feet.
//         return -1;
//     }
    
//     public int getInches() {
//         // TODO: Return the value of inches.
//         return -1;
//     }    
// }
// Task

// Your task is to implement the Dimension(int inches) constructor and getFeet() & getInches() methods in the Dimension class.

// Dimension(int inches) - This constructor will take one parameter, inches (an integer), and it should convert the given inches into feet and inches. If the input inches are less than 0, set feet and inches to -1 to indicate invalid input. One foot is equal to 12 inches.

// getFeet() - This method should return the calculated feet from the constructor.

// getInches() - This method should return the remaining inches (less than 12) from the constructor.

// Examples

// Here are some examples of how your Dimension class should behave once implemented:

// Dimension dim = new Dimension(25);
// System.out.println(dim.getFeet());    // Output: 2
// System.out.println(dim.getInches());  // Output: 1
// In the above example, 25 inches is equal to 2 feet and 1 inch.

// Dimension dim = new Dimension(-1);
// System.out.println(dim.getFeet());    // Output: -1
// System.out.println(dim.getInches());  // Output: -1
// In the above example, -1 inch is an invalid input so both getFeet() and getInches() return -1.

// Good luck!
```

class Dimension {
    private int feet;
    private int inches;
    
    public Dimension(int inches) {
        // TODO: Convert the total inches into feet and inches. One foot is 12 inches.
        // Store the feet and inches in their respective instance variables.
        if(inches < 0) {
            this.feet=-1;
            this.inches=-1;
        } else {
            this.feet = inches/12;
            this.inches = inches%12;
        }
    }
    
    public int getFeet() {
        // TODO: Return the value of feet.
        return feet;
    }
    
    public int getInches() {
        // TODO: Return the value of inches.
        return inches;
    }    
}
