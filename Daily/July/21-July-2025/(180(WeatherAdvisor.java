```

// Coding Exercise: Weather Advisor
// In this problem, you have to complete the implementation of a weatherAdviser class in Java that provides advice on what to wear based on the current temperature.

// Here is the skeleton of the WeatherAdviser class:

// public class weatherAdviser {
 
//     public String ProvideWeatherAdvisory(int temperature) {
//         // TODO: Provide a weather advisory message based on the temperature.
//         return "";
//     }
// }
// Task

// Your task is to implement the ProvideWeatherAdvisory(int temperature) method in the weatherAdviser class.

// ProvideWeatherAdvisory(int temperature) - This method will take one parameter, temperature (an integer), and it should return a String containing advice on what to wear according to the following guidelines:

// If the temperature is less than 0, return "It's freezing! Wear a heavy coat."

// If the temperature is between 0 and 10, inclusive, return "It's cold! Bundle up."

// If the temperature is between 11 and 20, inclusive, return "It's cool! A light jacket will do."

// If the temperature is above 20, return "It's warm! Enjoy the day."

// Examples

// Here are some examples of how your WeatherAdviser class should behave once implemented:

// WeatherAdviser adviser = new WeatherAdviser();
 
// System.out.println(adviser.ProvideWeatherAdvisory(-5));
// // Output: "It's freezing! Wear a heavy coat."
 
// System.out.println(adviser.ProvideWeatherAdvisory(5));
// // Output: "It's cold! Bundle up."
 
// System.out.println(adviser.ProvideWeatherAdvisory(15));
// // Output: "It's cool! A light jacket will do."
 
// System.out.println(adviser.ProvideWeatherAdvisory(25));
// // Output: "It's warm! Enjoy the day."
// Good luck!

```

class WeatherAdviser {
 
    public String provideWeatherAdvisory(int temperature) {
        
        if (temperature < 0) {
            return "It's freezing! Wear a heavy coat.";
        } 
        else if (temperature >= 0 && temperature <= 10) {
            return "It's cold! Bundle up.";
        } 
        else if (temperature >= 11 && temperature <= 20) {
            return "It's cool! A light jacket will do.";
        } 
        else {
            return "It's warm! Enjoy the day.";
        }
    }
}