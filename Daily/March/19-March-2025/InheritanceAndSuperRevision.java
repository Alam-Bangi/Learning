class InheritanceAndSuperRevision {
    public static void main(String[] args) {
        Shape circle = new Circle("RED", 2.34);
        circle.display();
        System.out.println();

        Shape rectangle = new Rectangle("BLUE", 4.56, 7.89);
        rectangle.display();
        System.out.println();

        Shape triangle = new Triangle("GREEN", 3.45, 6.78);
        triangle.display();
    }
}

class Shape {
    String colour;

    public Shape(String colour) {
        this.colour = colour;
    }

    public void display() {
        System.out.println("colour: " + colour);
    }
}

class Circle extends Shape {
    double radius;

    public Circle(String colour, double radius) {
        super(colour);
        this.radius = radius;
    }

    public void display() {
        System.out.println("Shape : Circle");
        super.display();
        System.out.println("radius: " + radius);
        System.out.println("Area: " + (Math.PI * radius * radius));
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(String colour, double length, double width) {
        super(colour);
        this.length = length;
        this.width = width;
    }

    public void display() {
        System.out.println("Shape : Rectangle");
        super.display();
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + (length * width));
    }
}

class Triangle extends Shape {
    double base;
    double height;

    public Triangle(String colour, double base, double height) {
        super(colour);
        this.base = base;
        this.height = height;
    }

    public void display() {
        System.out.println("Shape : Triangle");
        super.display();
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
        System.out.println("Area: " + (0.5 * base * height));
    }
}