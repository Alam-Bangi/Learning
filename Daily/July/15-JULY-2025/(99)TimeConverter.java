```

// Coding Exercise: Time convert
// In Java, you have been given a partially implemented TimeConvert class that aims to convert time from hours or days to minutes. The TimeConvert class has two static methods that need to be completed:

// convertHoursToMinutes(int hours): This method should take an integer value representing hours and return the equivalent value in minutes.

// convertDaysToMinutes(int days): This method should take an integer value representing days and return the equivalent value in minutes.

// Instructions
// Task 1: Complete the convertHoursToMinutes method in the TimeConvert class so that it accurately converts hours into minutes. The method should return an integer value representing the total number of minutes.
// Task 2: Complete the convertDaysToMinutes method in the TimeConvert class so that it accurately converts days into minutes. The method should return an integer value representing the total number of minutes.

// NOTE: Return -1 for invalid cases (days and hours less than 0).

```

class TimeConverter {
    public static int convertHoursToMinutes(int hours) {
        // Your task: complete this method
        if (hours < 0) {
        return -1;   
        }
        return hours * 60;
    }
}