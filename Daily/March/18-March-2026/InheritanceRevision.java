
class InheritanceRevision {
    public static void main(String[] args) {
        Person person = new Person("ALAM", 23, "Swargate, Pune");
        System.out.println(person);

        Person person2 = new Person();
        person2.setName("Bob");
        person2.setAge(30);
        person2.setAddress("Baner, Pune");
        System.out.println(person2);

        Person person3 = new Person();
        System.out.println(person3);
    }
}

class Person {
    String name;
    int age;
    String address;

    Person() {
    }

    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Person name = " + name + ", age = " + age + ", address = " + address;
    }
}
