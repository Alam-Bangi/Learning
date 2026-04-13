import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

class ArrayListEg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter 5 string values:");
        for (int i = 0; i < 5; i++) {
            list.add(sc.nextLine());
        }
        System.out.println("ArrayList: " + list);

        ArrayList<Byte> byteList = new ArrayList<>();
        System.out.println("Enter 5 byte values:");
        for (int i = 0; i < 5; i++) {
            byteList.add(sc.nextByte());
        }
        System.out.println("Byte ArrayList: " + byteList);

        ArrayList<Short> shortList = new ArrayList<>();
        System.out.println("Enter 5 short values:");
        for (int i = 0; i < 5; i++) {
            shortList.add(sc.nextShort());
        }
        System.out.println("Short ArrayList: " + shortList);

        ArrayList<Integer> intList = new ArrayList<>();
        System.out.println("Enter 5 integer values:");
        for (int i = 0; i < 5; i++) {
            intList.add(sc.nextInt());
        }
        System.out.println("Integer ArrayList: " + intList);

        ArrayList<Long> longList = new ArrayList<>();
        System.out.println("Enter 5 long values:");
        for (int i = 0; i < 5; i++) {
            longList.add(sc.nextLong());
        }
        System.out.println("Long ArrayList: " + longList);

        ArrayList<Float> floatList = new ArrayList<>();
        System.out.println("Enter 5 float values:");
        for (int i = 0; i < 5; i++) {
            floatList.add(sc.nextFloat());
        }
        System.out.println("Float ArrayList: " + floatList);

        ArrayList<Double> doubleList = new ArrayList<>();
        System.out.println("Enter 5 double values:");
        for (int i = 0; i < 5; i++) {
            doubleList.add(sc.nextDouble());
        }
        System.out.println("Double ArrayList: " + doubleList);

        ArrayList<Character> charList = new ArrayList<>();
        System.out.println("Enter 5 char values:");
        for (int i = 0; i < 5; i++) {
            charList.add(sc.next().charAt(0));
        }
        System.out.println("Character ArrayList: " + charList);

        ArrayList<Boolean> booleanList = new ArrayList<>();
        System.out.println("Enter 5 boolean values (true/false):");
        for (int i = 0; i < 5; i++) {
            booleanList.add(sc.nextBoolean());
        }
        System.out.println("Boolean ArrayList: " + booleanList);

        ArrayList<BigDecimal> bigDecimalList = new ArrayList<>();
        System.out.println("Enter 5 BigDecimal values:");
        for (int i = 0; i < 5; i++) {
            bigDecimalList.add(sc.nextBigDecimal());
        }
        System.out.println("BigDecimal ArrayList: " + bigDecimalList);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Alam", 23));
        persons.add(new Person("Bob", 25));
        System.out.println(persons);

        sc.close();
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "(Name- " + name + ", Age- " + age + ")";
    }
}