```

// Coding Exercise: Switch with Char - Is a Vowel or Not
// You are tasked with creating a method in the MyChar class to determine if a given character is a vowel.

// Here's a skeleton of the MyChar class for reference:

// public class MyChar {
 
//     // Method to determine if a character is a vowel
//     public boolean isVowel(char ch) {
    
//         // Use a switch statement to check for each vowel, both lowercase and uppercase
//         switch (ch) {
        
//             // TODO: Complete the switch statement
//         }
 
//         return false;
//     }
// }
// Task

// Your task is to implement the switch statement inside the isVowel(char ch) method.

// The switch statement should return true if the character is a vowel (either lowercase or uppercase) and false otherwise. The vowels are: 'A', 'E', 'I', 'O', 'U', and their respective lowercase versions.

// Examples

// Here are some examples of how your completed MyChar class should behave:

// MyChar myChar = new MyChar();
 
// System.out.println(myChar.isVowel('A'));  // Output: true
// System.out.println(myChar.isVowel('b'));  // Output: false
// System.out.println(myChar.isVowel('E'));  // Output: true
// System.out.println(myChar.isVowel('f'));  // Output: false
// Good luck with your implementation!

```

class MyChar {
 
    public boolean isVowel(char ch) {
 
        switch (ch) {
            
            case 'a', 'e', 'i', 'o', 'u' : 
            case 'A', 'E', 'I', 'O', 'U' : return true;
            
            default: return false;
        }
    }
}