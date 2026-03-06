class PatternMatchingRunner {
    public static void main(String[] args) {
        Object objStr = "Some String";

        instanceOfNew(objStr);
        instanceOfOld(objStr);
    }

    private static void instanceOfNew(Object objStr) {
        if (objStr instanceof String str) {
            System.out.println(str.toLowerCase());
        }
    }

    private static void instanceOfOld(Object objStr) {
        if (objStr instanceof String) {
            String str = (String) objStr;
            System.out.println(str.toLowerCase());
        }
    }
}
