class TreeMapRevision {
    public static void main(String[] args) {
        Map<Person, Integer> persons = new TreeMap<>(new Person("Alam"), new Person("Razin"),new Person("Zaid"));
        System.out.println(persons);
    }
}
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name;
    }
}