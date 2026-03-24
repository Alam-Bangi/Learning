import java.util.*;

class QueueAndMap {
    public static void main(String[] args) {
        Queue<String> customers = new LinkedList<>();
        customers.add("Alam");
        customers.add("Sami");
        customers.add("ASD");
        customers.add("Alam");
        customers.add("Sami");
        customers.add("Alam");

        Map<String, Integer> visitCount = new HashMap<>();
        while(!customers.isEmpty()) {
            String customer = customers.poll();
            Integer count = visitCount.get(customer);
            if(count==null) {
                visitCount.put(customer,1);
            } else {
                visitCount.put(customer, count+1);
            }
        }
        System.out.println(visitCount);
    }
}