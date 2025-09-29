import java.util.Scanner;

public class Solution1 {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        // 1. break the string into different parts of each length k starting from position 0 then position 1 and so on...
        //2. store the substrings in String[]
        //3. return the first substring as smallest as per the lexicographical order
        //4. return the last substring as largest as per the lexicographical order
        // System.out.println(s);
        // System.out.println(s.length()-(k-1));
        // String[] substrings = new String[s.length()-(k-1)];
        smallest= s.substring(0, k);
        largest = s.substring(0, k);
        for (int i=0; i<s.length()-(k-1); i++) {
            String substringcontent = s.substring(i, k+i);
            // System.out.println(substringcontent);
            // s.compareTo(substringcontent); 
            // substrings[i] = substringcontent;
            if(substringcontent.compareTo(smallest)<0) {
                smallest = substringcontent;
            } 
            if(substringcontent.compareTo(largest)>0) {
                largest = substringcontent;
            }     
        }
        
        
        return smallest + "\n" + largest;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}