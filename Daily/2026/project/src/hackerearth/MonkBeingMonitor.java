package hackerearth;

import java.util.*;

public class MonkBeingMonitor {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int height = sc.nextInt();
                freq.put(height, freq.getOrDefault(height, 0) + 1);
            }
            ArrayList<Integer> counts = new ArrayList<>(freq.values());
            Collections.sort(counts);

            int diff = counts.get(counts.size() - 1) - counts.get(0);
            if (diff > 0) {
                System.out.println(diff);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
