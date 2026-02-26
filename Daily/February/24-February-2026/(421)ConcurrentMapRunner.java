import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;

class ConcurrentMapRunner {
    public static void main(String[] args) {
        ConcurrentMap<Character, LongAdder> occurances = new ConcurrentHashMap<>();
        String str = "alam alam alam";
        for (char c : str.toCharArray()) {
            occurances.computeIfAbsent(c, k -> new LongAdder()).increment();
            // LongAdder longAdder = occurances.get(c);
            // if (longAdder == null) {
            // longAdder = new LongAdder();
            // }
            // longAdder.increment();
            // occurances.put(c, longAdder);
        }
        System.out.println(occurances);
    }
}
