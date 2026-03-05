class RecordsRunner {
    record Person(String name, String email, String phone) {
        // Person(String name, String email, String phone) {
            Person {
                if (name == null || email == null || phone == null) {
                throw new IllegalArgumentException("All fields must be non-null");
            }
            }
            
            // this.name = name;
            // this.email = email;
            // this.phone = phone;
    }
    // }

    public static void main(String[] args) {
        Person person = new Person("John", "john@example.com", "123-456-7890");
        System.out.println(person);
        // Person person2 = new Person("Doe", "doe@example.com", "123-456-7890");
        // System.out.println(person2);
    }
}
