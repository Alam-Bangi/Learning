import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class MapOperations {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Mango");
        System.out.println("Initial Map: " + map);

        map.putIfAbsent(2, "Orange");
        map.putIfAbsent(5, "Orange");
        System.out.println("\nAfter putIfAbsent(): " + map);

        System.out.println("\nValue for key 3: " + map.get(3));
        System.out.println("\nValue for key 10: " + map.get(10));

        System.out.println("\ngetOrDefault(): " + map.getOrDefault(10, "Not Found"));

        System.out.println("\nContains key 2? " + map.containsKey(2));
        System.out.println("\nContains value Mango? " + map.containsValue("Mango"));

        System.out.println("\nSize: " + map.size());
        System.out.println("\nIs Empty? " + map.isEmpty());

        map.replace(2, "Blueberry");
        System.out.println("\nAfter replace(): " + map);

        map.replace(3, "Cherry", "Grapes");
        System.out.println("\nConditional replace(): " + map);

        map.remove(5);
        System.out.println("\nAfter remove(key): " + map);
        map.remove(4, "Mango");
        System.out.println("\nAfter remove(key,value): " + map);

        System.out.println("\nUsing entrySet():");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUsing keySet():");
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println("\nUsing values():");
        for (String value : map.values()) {
            System.out.println(value);
        }

        System.out.println("\nUsing forEach():");
        map.forEach((k, v) -> System.out.println(k + " : " + v));

        map.computeIfAbsent(10, k -> "Watermelon");
        System.out.println("\nAfter computeIfAbsent(): " + map);

        map.replaceAll((k, v) -> v.toLowerCase());
        System.out.println("\nAfter replaceAll(): " + map);

        Map<Integer, String> another = new HashMap<>();
        another.put(100, "Java");
        another.put(101, "Python");

        map.putAll(another);

        System.out.println("\nAfter putAll(): " + map);

        System.out.println("\nmap.equals(map): " + map.equals(map));

        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(3, "C");
        linkedMap.put(1, "A");
        linkedMap.put(2, "B");

        System.out.println("\nLinkedHashMap (Insertion Order):");
        System.out.println(linkedMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");

        System.out.println("\nTreeMap (Sorted Keys):");
        System.out.println(treeMap);

        map.clear();
        System.out.println("\nAfter clear(): " + map);
        System.out.println("Is Empty? " + map.isEmpty());
    }
}