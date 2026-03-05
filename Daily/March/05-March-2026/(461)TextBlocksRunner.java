class TextBlocksRunner {
    public static void main(String[] args) {
        String str = """
                Line 1
                Line 2
                Line 3
                """;
        System.out.println(str);

        String textBlock = """
                Line 1 : %s
                Line 2 : %s
                """.formatted("A", "B");
        System.out.println(textBlock);
    }
}
