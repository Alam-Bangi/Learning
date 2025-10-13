class SwitchCase {
    public static void main(String[] args) {
        
        System.out.println("Result: " + switchExample('A'));
        System.out.println("Result: " + switchExample2("Banana"));
        System.out.println("Result: " + switchExample3((byte)2));
        System.out.println("Result: " + switchExample1((short)5));
        System.out.println("Result: " + switchExample4(10));
    }
     public static String switchExample1(short day) {
        switch (day) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4: 
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "Invalid day";
        }
    }   

    public static String switchExample(char grade) {
        switch (grade) {
            case 'A': 
                return "Excellent";
            case 'B':
                return "Very Good";
            case 'C':
                return "Good";
            case 'D':
                return "Fair";
            case 'F':
                return "Fail";
        }
        return "Invalid grade";
    }
    
    public static String switchExample2(String fruit) {
        switch(fruit) {
            case "Apple":
                return "It's a Red fruit";
            case "Banana":
                return "It's a Yellow fruit";
            case "Orange":
                return "It's an Orange fruit";
            default:
                return "Unknown color";
        }
    }
    public static String switchExample3(byte num) {
        switch (num) {
            case 0:
                return "Fan is On but speed is 0";
            case 1:
                return "Fan is slow";
            case 2:
                return "Fan is medium";
            case 3:
                return "Fan is fast";
            default:
                return "Fan is off";
        }
    }
    public static String switchExample4(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Invalid month";
        }
    }
}