import java.util.Scanner;

class TrafficLightRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== Traffic Signal Menu =====");
            System.out.println("1. RED Light");
            System.out.println("2. YELLOW Light");
            System.out.println("3. GREEN Light");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    handleSignal(TrafficLight.RED);
                    break;

                case 2:
                    handleSignal(TrafficLight.YELLOW);
                    break;

                case 3:
                    handleSignal(TrafficLight.GREEN);
                    break;

                case 4:
                    System.out.println("\nExiting Program...");
                    break;

                default:
                    System.out.println("\nInvalid Choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    public static void handleSignal(TrafficLight light) {

        switch (light) {

            case RED:
                System.out.println("\nRED Light");
                System.out.println("Action: Stop the vehicle");
                break;

            case YELLOW:
                System.out.println("\nYELLOW Light");
                System.out.println("Action: Get Ready");
                break;

            case GREEN:
                System.out.println("\nGREEN Light");
                System.out.println("Action: Go");
                break;

            default:
                System.out.println("Invalid Signal");
        }
    }
}

enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}