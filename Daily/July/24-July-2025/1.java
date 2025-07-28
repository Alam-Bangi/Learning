
class Main {
    public static void main(String[] args) {
        System.out.println(isWeekDay(0));
        System.out.println(determineNameOfMonth(7));
        System.out.println(determineNameOfDay(4));
    }
    
    public static boolean isWeekDay(int dayNumber) {
        switch (dayNumber) {
            case 0 : return false;
            case 6 : return false;
            case 1 : return true;
            case 2 : return true;
            case 3 : return true;
            case 4 : return true;
            case 5 : return true;
        }
        return false;
    }
    
    public static String determineNameOfMonth(int monthNumber) {
        switch (monthNumber) {
            case 1 : return "January";
            case 2 : return "February";
            case 3 : return "March";
            case 4 : return "April";
            case 5 : return "May";
            case 6 : return "June";
            case 7 : return "July";
            case 8 : return "August";
            case 9 : return "September";
            case 10 : return "October";
            case 11 : return "November";
            case 12 : return "December";
        }
        return "Invalid_monthNumber";
    }
    
     public static String determineNameOfDay(int dayNumberr) {
        switch (dayNumberr) {
            case 1 : return "Monday";
            case 2 : return "Tuesday";
            case 3 : return "Wednesday";
            case 4 : return "Thursday";
            case 5 : return "Friday";
            case 6 : return "Saturday";
            case 7 : return "Sunday";
        }
        return "Invalid Day";
    }
}