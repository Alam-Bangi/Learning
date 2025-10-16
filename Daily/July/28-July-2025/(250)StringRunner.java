class StringRunner {
    public static void main(String[] args) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        String dayWithMostCharacters = "";
        for (String day : daysOfWeek) {
            if (day.length() > dayWithMostCharacters.length()) {
                dayWithMostCharacters = day;
            }
        }
        System.out.println("Day with most characters: " + dayWithMostCharacters);

        for(int i =0; i<daysOfWeek.length; i++) {
            System.out.println(daysOfWeek[i]);
        }
    }
}