public class RectangleRunner {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(12, 10);
        System.out.println(rectangle);
        rectangle.setLength(20);
        rectangle.setWidth(15);
        System.out.println(rectangle);
    }
}
public class Rectangle {
    private int length;
    private int width;
    // private String colour;
    
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int area() {
        return length * width;
    }
    public int perimeter() {
        return 2*(length+width);
    }
    public String toString() {
        return String.format("length - &d width- %d area - %d perimeter- %d" , length, width, area(), perimeter());
    }
}
    