import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class GenericQueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of queue: ");
        int size = sc.nextInt();

        sc.close();

        System.out.println("-----Integer Queue-----\n");
        MyPriorityQueue<Integer> intQueue = new MyPriorityQueue<>(size);

        intQueue.push(10);
        intQueue.push(20);
        intQueue.push(30);
        intQueue.push(40);
        intQueue.push(50);

        intQueue.display();

        intQueue.pop();
        intQueue.pop();
        System.out.println("Top element: " + intQueue.peek());
        System.out.println("Size of Queue: " + intQueue.size());
        System.out.println("Is Queue Empty? : " + intQueue.isEmpty());

        intQueue.clear();
        System.out.print("After clearing ");
        intQueue.display();

        System.out.println("\n-----String Queue-----\n");
        MyPriorityQueue<String> strQueue = new MyPriorityQueue<>();

        strQueue.push("ABC");
        strQueue.push("PQR");
        strQueue.push("GHI");
        strQueue.push("XYZ");
        strQueue.push("LMN");

        strQueue.display();

        strQueue.pop();
        strQueue.pop();
        strQueue.remove("PQR");

        strQueue.display();
        System.out.println("Top element: " + strQueue.peek());
        System.out.println("Size of Queue: " + strQueue.size());
        System.out.println("Is Queue Empty? : " + strQueue.isEmpty());

        strQueue.clear();
        System.out.print("After clearing ");
        strQueue.display();
    }
}

class MyPriorityQueue<T> {

    private Queue<T> queue;
    private int size;

    public MyPriorityQueue() {
        this.queue = new PriorityQueue<>();
        this.size = 3;
    }

    public MyPriorityQueue(int size) {
        this.queue = new PriorityQueue<>();
        this.size = size;
    }

    public void push(T element) {
        if (queue.size() < size) {
            queue.offer(element);
            System.out.println(element + " added to Queue");
        }
    }

    public void pop() {
        if (queue.size() > 0) {
            System.out.println("Removed Element: " + queue.poll());
        }
    }

    public void remove(T element) {
        if (queue.contains(element)) {
            queue.remove(element);
            System.out.println("Removed Element: " + element);
        }
    }

    public T peek() {
        return queue.peek();
    }

    public void clear() {
        if (!queue.isEmpty()) {
            queue.clear();
            System.out.println("Cleared Queue");
        } else {
            System.out.println("Nothing to clear");
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void display() {
        System.out.println("Queue: " + queue);
    }
}