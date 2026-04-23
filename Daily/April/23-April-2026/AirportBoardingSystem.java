import java.util.*;

class AirportBoardingSystem {

    static Scanner sc = new Scanner(System.in);
    static int counter = 0;

    public static void main(String[] args) {

        PriorityQueue<Passenger> queue = new PriorityQueue<>(new PassengerComparator());

        while (true) {
            System.out.println("\n===== AIRPORT BOARDING SYSTEM =====");
            System.out.println("1. Add Passenger");
            System.out.println("2. Board Passenger");
            System.out.println("3. View Next Passenger");
            System.out.println("4. Display All");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPassenger(queue);
                    break;
                case 2:
                    boardPassenger(queue);
                    break;
                case 3:
                    viewNext(queue);
                    break;
                case 4:
                    display(queue);
                    break;
                case 5:
                    System.out.println("System Closed..!!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addPassenger(PriorityQueue<Passenger> queue) {
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter class (1 = Business, 2 = Economy): ");
        int type = sc.nextInt();
        while (!(type > 0 && type < 3)) {
            System.out.print("Enter valid class (1 = Business, 2 = Economy): ");
            type = sc.nextInt();
        }

        Passenger p = new Passenger(name, type, counter++);
        queue.offer(p);

        System.out.println("Passenger added.");
    }

    static void boardPassenger(PriorityQueue<Passenger> queue) {
        Passenger p = queue.poll();
        if (p == null) {
            System.out.println("No passenger to board.");
        } else {
            System.out.println("Boarding: " + p);
        }
    }

    static void viewNext(PriorityQueue<Passenger> queue) {
        Passenger p = queue.peek();
        if (p == null) {
            System.out.println("No passangers left to board.");
        } else {
            System.out.println("Next: " + p);
        }
    }

    static void display(PriorityQueue<Passenger> queue) {
        if (queue.isEmpty()) {
            System.out.println("No passangers to display.");
            return;
        }

        System.out.println("All Passengers:");
        for (Passenger p : queue) {
            System.out.println(p);
        }
    }
}

class Passenger {
    String name;
    int type;
    int order;

    Passenger(String name, int type, int order) {
        this.name = name;
        this.type = type;
        this.order = order;
    }

    public String toString() {
        String cls = (type == 1) ? "Business" : "Economy";
        return name + " [" + cls + "]";
    }
}

class PassengerComparator implements Comparator<Passenger> {
    public int compare(Passenger p1, Passenger p2) {

        if (p1.type != p2.type) {
            return p1.type - p2.type;
        }

        return p1.order - p2.order;
    }
}