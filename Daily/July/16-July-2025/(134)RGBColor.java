```
// Coding Exercise: RGB Color Class
// The Red-Green-Blue (RGB) model is a popular way to represent colors in computer systems. In this model, each color is represented as a combination of the primary colors red, green, and blue. Each of these primary colors can have intensity values ranging from 0 to 255.

// In this exercise, you are tasked with completing the RGBColor class that models a color in the RGB model. The class has fields for the red, green, and blue intensities, and methods to get these values.

// Additionally, there's an invert method that changes the color to its complementary color (the inverse color on a color wheel).

// You need to implement the constructor, the getter methods for the red, green, and blue values, and the invert method.

// The invert method should subtract the current intensity value of each primary color from 255 to get the inverted color.

// Please follow the provided skeleton code and fill in the missing parts.

// Instructions

// Start by implementing the constructor of the RGBColor class. The constructor should take three arguments: red, green, and blue. These should be used to initialize the red, green, and blue fields of the class.

// Implement the getRed, getGreen, and getBlue methods. These methods should return the current values of the red, green, and blue fields respectively.

// Implement the invert method. This method should subtract the current value of each of the red, green, and blue fields from 255, and assign the result back to the respective field.

// Examples

// Below are three examples of creating an RGBColor object, getting the red, green, and blue values, and inverting the color.

// Example 1

// RGBColor color = new RGBColor(255, 0, 0);
// System.out.println(color.getRed());   // Prints: 255
// System.out.println(color.getGreen()); // Prints: 0
// System.out.println(color.getBlue());  // Prints: 0
// color.invert();
// System.out.println(color.getRed());   // Prints: 0
// System.out.println(color.getGreen()); // Prints: 255
// System.out.println(color.getBlue());  // Prints: 255
// Example 2

// RGBColor color = new RGBColor(0, 255, 0);
// color.invert();
// System.out.println(color.getGreen()); // Prints: 0
// Example 3

// RGBColor color = new RGBColor(128, 128, 128);
// color.invert();
// System.out.println(color.getRed());   // Prints: 127
// System.out.println(color.getGreen()); // Prints: 127
// System.out.println(color.getBlue());  // Prints: 127

```

class RGBColor {
    
    // The Red, Green, Blue color values range from 0 to 255.
    private int red;
    private int green;
    private int blue;

    // Constructor for RGBColor class which initializes the color with provided red, green and blue values.
    public RGBColor(int red, int green, int blue) {
        // write your code here
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // Getter method to get the red value of the color.
    public int getRed() {
        // write your code here
        return red;
    }

    // Getter method to get the green value of the color.
    public int getGreen() {
        // write your code here
        return green;
    }

    // Getter method to get the blue value of the color.
    public int getBlue() {
        // write your code here
        return blue;
    }

    // Method to invert the color. The inversion is done by subtracting each color component from 255.
    public void invert() {
        // write your code here
    red = 255 - red;
    green = 255 - green;
    blue = 255 - blue;
    }
}
