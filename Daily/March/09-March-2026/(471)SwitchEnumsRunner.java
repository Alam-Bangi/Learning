import java.time.DayOfWeek;

class SwitchEnumsRunner {
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        String str = switch (dayOfWeek) {
            case MONDAY -> "First day of the work week!";
            case TUESDAY, WEDNESDAY, THURSDAY -> "Middle of the work week!";
            case FRIDAY -> "Last day of the work week!";
            default -> "Weekend!!!";
        };
        System.out.println(str);
    }
}
