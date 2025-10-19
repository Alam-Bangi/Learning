/**
 
Java Coding Exercise - Shapes and Area
In this exercise, you are given a partially completed Java program that is intended to create shapes, calculate their areas, and print information about them.

The program defines an abstract base class, Shape, with sub classes for specific types of shapes.

Each shape must be able to calculate its own area.

The shapes we are considering for this exercise are Circle and Rectangle.

Your task is to complete the code by implementing the Circle and Rectangle classes that extend the Shape abstract class.

Each of these classes must include a calculateArea() method that computes and returns the area of the shape.

Edge Conditions

The radius of a circle and the length and width of a rectangle should be positive numbers. You can assume that they will be positive in the input.

Input Format

The input will be the dimensions of the shapes, passed to their respective constructors when creating instances. For a circle, its radius is the input. For a rectangle, its length and width are the inputs.

For example:

Shape circle = new Circle("Circle", 5.0); // Here, "Circle" is the name and 5.0 is the radius
 
Shape rectangle = new Rectangle("Rectangle", 4.0, 6.0); // Here, "Rectangle" is the name, 4.0 is the length, and 6.0 is the width


Formulae

Area of Circle -  Math.PI * radius * radius.

Area of Rectangle -  length * width.

Notes

In this exercise, we are using inheritance and abstract classes. The Shape class is an abstract class and it is extended by the Circle and Rectangle classes.

super(name) is used to call the constructor of the superclass, Shape. This is required as the first statement in the constructors of Circle and Rectangle.

Math.PI is a constant that represents the value of PI, approximately 3.14159. It is used to calculate the area of a circle.

calculateArea() is an abstract method in Shape and it is implemented (overridden) in the Circle and Rectangle classes.

The this keyword refers to the current object, and it's used to access the object's attributes.

 */

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double calculateArea();

    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Area: " + calculateArea());
    }
}
class Circle extends Shape {
    private double radius; 
 
    public Circle(String name, double radius) {
        super(name); 
        this.radius = radius;
    }
 
    public double calculateArea() {
        return Math.PI * radius * radius; 
    }
}
 
class Rectangle extends Shape {
    private double length;
    private double width; 
 
    public Rectangle(String name, double length, double width) {
        super(name); 
        this.length = length;
        this.width = width;
    }
 
    public double calculateArea() {
        return length * width; 
    }
}
