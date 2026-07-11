import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class StudentAttendance {

    public static void main(String[] args) {

        Map<Integer, String> attendance = new HashMap<>();

        attendance.put(101, "Present");
        attendance.put(102, "Absent");
        attendance.put(103, "Present");
        attendance.put(104, "Absent");

        System.out.println("Initial Attendance:");
        System.out.println(attendance);

        attendance.putIfAbsent(102, "Present");
        attendance.putIfAbsent(105, "Present");

        System.out.println("\nAfter putIfAbsent():");
        System.out.println(attendance);

        System.out.println("\nAttendance of Student 103: " + attendance.get(103));

        System.out.println("Attendance of Student 110: "
                + attendance.getOrDefault(110, "Student Not Found"));

        System.out.println("\nContains Student ID 101? "
                + attendance.containsKey(101));

        System.out.println("Any student absent? "
                + attendance.containsValue("Absent"));

        System.out.println("\nTotal Students: " + attendance.size());

        System.out.println("Is Attendance Empty? " + attendance.isEmpty());

        attendance.replace(102, "Present");

        System.out.println("\nAfter replace():");
        System.out.println(attendance);

        attendance.replace(104, "Absent", "Present");

        System.out.println("\nAfter Conditional replace():");
        System.out.println(attendance);

        attendance.remove(105);

        System.out.println("\nAfter remove(key):");
        System.out.println(attendance);

        attendance.remove(104, "Present");

        System.out.println("\nAfter remove(key,value):");
        System.out.println(attendance);

        System.out.println("\nUsing entrySet():");
        for (Map.Entry<Integer, String> entry : attendance.entrySet()) {
            System.out.println("Student ID: " + entry.getKey()
                    + " Attendance: " + entry.getValue());
        }

        System.out.println("\nUsing keySet():");
        for (Integer id : attendance.keySet()) {
            System.out.println(id + " -> " + attendance.get(id));
        }

        System.out.println("\nUsing values():");
        for (String status : attendance.values()) {
            System.out.println(status);
        }

        System.out.println("\nUsing forEach():");
        attendance.forEach((id, status) -> System.out.println(id + " : " + status));

        attendance.computeIfAbsent(106, k -> "Absent");

        System.out.println("\nAfter computeIfAbsent():");
        System.out.println(attendance);

        attendance.replaceAll((id, status) -> status.toUpperCase());

        System.out.println("\nAfter replaceAll():");
        System.out.println(attendance);

        Map<Integer, String> extraStudents = new HashMap<>();
        extraStudents.put(107, "PRESENT");
        extraStudents.put(108, "ABSENT");

        attendance.putAll(extraStudents);

        System.out.println("\nAfter putAll():");
        System.out.println(attendance);

        System.out.println("\nattendance.equals(attendance): "
                + attendance.equals(attendance));

        Map<Integer, String> linkedAttendance = new LinkedHashMap<>();
        linkedAttendance.put(103, "Present");
        linkedAttendance.put(101, "Present");
        linkedAttendance.put(102, "Absent");

        System.out.println("\nLinkedHashMap (Insertion Order):");
        System.out.println(linkedAttendance);

        Map<Integer, String> sortedAttendance = new TreeMap<>();
        sortedAttendance.put(103, "Present");
        sortedAttendance.put(101, "Present");
        sortedAttendance.put(102, "Absent");

        System.out.println("\nTreeMap (Sorted Student IDs):");
        System.out.println(sortedAttendance);

        attendance.clear();

        System.out.println("\nAfter clear():");
        System.out.println(attendance);

        System.out.println("Is Attendance Empty? "
                + attendance.isEmpty());
    }
}