
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Task1 {
    public static void main(String[] args) {
        String str = "This is a test";
        str = str.toLowerCase(Locale.getDefault());
        Map<Character, Integer> occurances = new HashMap<>();
        char[] characters = str.toCharArray();
        for (char ch:characters) {
            Integer integer = occurances.get(ch);
            if(integer==null) {
                occurances.put(ch,1);
            } else {
                occurances.put(ch, integer+1);
            }
        }
        System.out.println(occurances);
    }
}