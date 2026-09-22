package random;

class Address implements Cloneable {
    String city;

    Address(String city){
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class PersoN implements Cloneable{
    String name;
    Address addr;

    PersoN(String name, Address addr){
        this.name = name;
        this.addr = addr;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        PersoN cloned = (PersoN)super.clone();
        cloned.addr = (Address)addr.clone();
        return cloned;
    }
}

public class DeepCopyWithClone {
    public static void main(String[] args) throws CloneNotSupportedException{
        Address a1 = new Address("London");
        PersoN p1 = new PersoN("Alice", a1);

        PersoN p2 = (PersoN)p1.clone();

        System.out.println("Original City: " + p1.addr.city);
        System.out.println("Copied City: " + p2.addr.city);

        p2.addr.city = "Paris";

        System.out.println("\nAfter modification:");
        System.out.println("Original City: " + p1.addr.city);
        System.out.println("Copied City: " + p2.addr.city);
    }
}