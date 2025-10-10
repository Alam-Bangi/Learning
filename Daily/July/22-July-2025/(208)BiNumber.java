```

// Coding Exercise: LCM Of A Number
// You have a class BiNumber with two integer attributes number1 and number2. The task is to complete the method calculateLCM() in the BiNumber class.

// The method calculateLCM() should calculate the Least Common Multiple (LCM) of number1 and number2 and return it.

// If either number1 or number2 is negative, the method should return -1 because the LCM of negative numbers is undefined.

// If either number1 or number2 is zero, the method should return 0 because the LCM of 0 and any other number is 0.

// Mathematical Expression

// The least common multiple (LCM) of two integers a and b is the smallest positive integer that is divisible by both a and b. In other words, the LCM of a and b is the smallest number that is a multiple of a and b.

// Example: If a is 6 and b is 8, the LCM of 6 and 8 is 24 because 24 is the smallest number that is a multiple of both 6 and 8.

// Other Examples

// Given number1 is 5 and number2 is 10, when calculateLCM() is called, it should return 10.

// Given number1 is 0 and number2 is 5, when calculateLCM() is called, it should return 0.

// Given number1 is -2 and number2 is 5, when calculateLCM() is called, it should return -1.

// Logic

// LCM of a and b is always a multiple of a and b.

// One approach to take is to first find the maximum of a and b. Call it max.

// If max is divisible by a and b, then max is the LCM.

// Otherwise, we can use a while loop to check which multiple of max is divisible by both a and b.

// Step By Step Example

// Here are some step-by-step examples:

// For number1 = 5 and number2 = 10:

// The maximum of number1 and number2 is 10. So, start with lcm = 10.

// 10 is divisible by both 5 and 10, so lcm = 10 is the LCM of 5 and 10.

// For number1 = 6 and number2 = 8:

// The maximum of number1 and number2 is 8. So, start with lcm = 8.

// 8 is not divisible by 6.

// Increment lcm by 8 (max) to get lcm = 16.

// 16 is not divisible by both 6 and 8. So, increment lcm by 8 to get lcm = 24.

// 24 is divisible by both 6 and 8, so lcm = 24 is the LCM of 6 and 8.

```

class BiNumber {
    private int number1;
    private int number2;
 
    public BiNumber(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
 
    public int getNumber1() {
        return number1;
    }
 
    public int getNumber2() {
        return number2;
    }
 
    public int calculateLCM() {
        if (number1 == 0 || number2 == 0) {
            return 0; 
        }
        if (number1 < 0 || number2 < 0) {
            return -1;
        }
 
     
        int max = Math.max(number1, number2);
  
        int lcm = max;
 

        while (true) {
            if (lcm % number1 == 0 && lcm % number2 == 0) {
               
                break;
            }
       
            lcm += max;
        }
 
    
        return lcm;
    }
}