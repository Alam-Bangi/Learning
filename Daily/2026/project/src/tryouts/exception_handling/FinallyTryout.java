package tryouts.exception_handling;

public class FinallyTryout {
    public static void main(String[] args) {

        System.out.println(test());
//        systemExit();
//        throwingException();
//        System.out.println(returnAndFinally());
    }
    public static int test() {
        try {
            System.out.println("Inside try");
            return 10;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            return 20;
        }
    }
    public static void systemExit(){
        try {
            System.out.println("try");
            System.exit(0);
        } finally {
            System.out.println("finally");
        }
    }
    public static void throwingException() {
        try {
            System.out.println("Inside try");
            throw new RuntimeException();
        } finally {
            System.out.println("finally");
        }
    }
    public static int returnAndFinally() {
        try {
            System.out.println("Inside try");
            return 10;
        } finally {
            System.out.println("finally");
        }
    }
}

