import java.util.HashMap;
import java.util.Map;

class OccuranceMap {
    public static void main(String[] args) {
        String s = "How much wood would a woodchuck chuck, if a woodchuck could chuck wood?";

        Map<Character, Integer> occurances = new HashMap<>();

        char[] characters = s.toLowerCase().toCharArray();

        for (char c : characters) {
            Integer count = occurances.get(c);
            if (count == null) {
                occurances.put(c, 1);
            } else {
                occurances.put(c, count + 1);
            }
        }
        System.out.println(occurances);

        Map<String, Integer> stringOccurances = new HashMap<>();

        String[] words = s.split(" ");

        for (String word : words) {
            Integer occured = stringOccurances.get(word);
            if (occured == null) {
                stringOccurances.put(word, 1);
            } else {
                stringOccurances.put(word, occured + 1);
            }
        }
        System.out.println(stringOccurances);
    }
}
