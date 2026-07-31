package random;

import java.util.Arrays;
public class Anagram {
    public static void main(String[] args) {
        String s1  = "graph";
        String s2 = "phragh";
        if(isAnagram(s1, s2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }
    public static boolean isAnagram(String s1, String s2) {
        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}