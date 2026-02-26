class CopyOnWriteArrayListRunner {
    public static void main(String[] args) {
        List list = new CopyOnWriteArrayList<>();
        list.add("Ant");
        list.add("Bat");
        list.add("Cat");

        for (String element:list) {
            System.out.println(element);
        }
    }
}