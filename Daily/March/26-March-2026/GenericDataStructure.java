import java.util.ArrayList;
import java.util.EmptyStackException;

class GenericDataStructure {
    public static void main(String[] args) {

        System.out.println("---- Integer Stack ----");
        GenericStack<Integer> intStack = new GenericStack<>();

        System.out.println("Is Stack Empty? " + intStack.isEmpty());
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

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
    }
}

class GenericStack<T> {

    private ArrayList<T> elements;

    public GenericStack() {
        elements = new ArrayList<>();
    }

    public void push(T item) {
        elements.add(item);
        System.out.println(item + " pushed to stack");
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
}
