import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        LocalDate specificDate = LocalDate.of(2002, 11, 12);
        System.out.println("Specific Date: " + specificDate);

        System.out.println("Year: " + currentDate.getYear());
        System.out.println("Month: " + currentDate.getMonth());
        System.out.println("Day: " + currentDate.getDayOfMonth());

        LocalDate nextWeek = currentDate.plusDays(7);
        LocalDate lastWeek = currentDate.minusDays(7);

        System.out.println("Next Week: " + nextWeek);
        System.out.println("Last Week: " + lastWeek);

        if (currentDate.isAfter(specificDate)) {
            System.out.println("Current date is after the specific date");
        } else {
            System.out.println("Current date is before or equal to the specific date");
        }
    }
}