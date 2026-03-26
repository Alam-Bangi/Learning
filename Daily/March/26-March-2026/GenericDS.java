import java.util.*;

class GenericDS {
    public static void main(String[] args) {

        // Queue<Integer> no = new LinkedList<>();
        // no.remove();

        // Stack<Integer> noStack = new Stack<>();
        // noStack.pop();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of list: ");
        int size = sc.nextInt();

        System.out.println("---- Integer Stack ----");
        GenericStack<Integer> intStack = new GenericStack<>(size);

        System.out.println("Is Stack Empty? " + intStack.isEmpty());
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.push(40);
        intStack.push(50);
        intStack.push(40);
        // intStack.push(70);

        System.out.println("Size of Stack: " + intStack.size());

        intStack.display();

        System.out.println("Popped element: " + intStack.pop());

        intStack.display();

        System.out.println("\n---- String Stack ----");
        GenericStack<String> stringStack = new GenericStack<>();

        stringStack.push("Hello");
        stringStack.push("Java");
        stringStack.push("Generics");

        System.out.println("Is Stack Empty? " + stringStack.isEmpty());
        stringStack.display();

        System.out.println("Popped element: " + stringStack.pop());

        stringStack.display();
        System.out.println(stringStack);
    }
}

class GenericStack<T> {

    private ArrayList<T> elements;
    private int size;

    public GenericStack() {
        this.elements = new ArrayList<>();
        this.size = 5;

        System.out.println(toString());
    }

    public GenericStack(int size) {
        this.elements = new ArrayList<>();
        this.size = size;
        System.out.println(toString());
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void push(T item) {
        if (elements.size() > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            elements.add(item);
            System.out.println(item + " pushed to stack");
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public void display() {
        System.out.println("Stack elements: " + elements);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(elements).append(" Size: ").append(size);
        return str.toString();
    }
}
