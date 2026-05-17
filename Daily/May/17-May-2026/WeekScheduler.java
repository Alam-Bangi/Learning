import java.util.Scanner;

class WeekScheduler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== Week Scheduler Menu =====");
            System.out.println("1. MONDAY");
            System.out.println("2. TUESDAY");
            System.out.println("3. WEDNESDAY");
            System.out.println("4. THURSDAY");
            System.out.println("5. FRIDAY");
            System.out.println("6. SATURDAY");
            System.out.println("7. SUNDAY");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showSchedule(Day.MONDAY);
                    break;

                case 2:
                    showSchedule(Day.TUESDAY);
                    break;

                case 3:
                    showSchedule(Day.WEDNESDAY);
                    break;

                case 4:
                    showSchedule(Day.THURSDAY);
                    break;

                case 5:
                    showSchedule(Day.FRIDAY);
                    break;

                case 6:
                    showSchedule(Day.SATURDAY);
                    break;

                case 7:
                    showSchedule(Day.SUNDAY);
                    break;

                case 8:
                    System.out.println("\nExiting Program...");
                    break;

                default:
                    System.out.println("\nInvalid Choice! Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }

    public static void showSchedule(Day day) {

        switch (day) {

            case MONDAY:
                System.out.println("\nMONDAY Schedule");
                System.out.println("Java - Arrays/ArrayList");
                break;

            case TUESDAY:
                System.out.println("\nTUESDAY Schedule");
                System.out.println("Java - Interfaces");
                break;

            case WEDNESDAY:
                System.out.println("\nWEDNESDAY Schedule");
                System.out.println("Java - Abstract Class");
                break;

            case THURSDAY:
                System.out.println("\nTHURSDAY Schedule");
                System.out.println("Java - Generics");
                break;

            case FRIDAY:
                System.out.println("\nFRIDAY Schedule");
                System.out.println("Java - Threads");
                break;

            case SATURDAY:
                System.out.println("\nSATURDAY Schedule");
                System.out.println("Java - Functional Programming");
                break;

            case SUNDAY:
                System.out.println("\nSUNDAY Schedule");
                System.out.println("Java - Exception Handling");
                break;

            default:
                System.out.println("Invalid Day");
        }
    }
}

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}