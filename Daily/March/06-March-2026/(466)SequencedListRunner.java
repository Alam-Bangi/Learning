import java.util.ArrayList;

class SequencedListRunner {
    public static void main(String[] args) {
        var courseDetails = new ArrayList<>();

        courseDetails.add("Spring Security");

        courseDetails.addFirst("Spring Boot");
        courseDetails.addLast("Spring Boot in AI");

        courseDetails.add("Cloud Computing with AWS");
        courseDetails.add("Cloud Computing with Azure");

        System.out.println("First Course: " + courseDetails.getFirst());
        System.out.println("Last Course: " + courseDetails.getLast());

        System.out.println("Remove First Course: " + courseDetails.removeFirst());
        System.out.println("Remove Last Course: " + courseDetails.removeLast());

        var reverseCourseDetails = courseDetails.reversed();
        System.out.println("Courses in Reverse Order:" + reverseCourseDetails);
    }
}
