public class CustomerRunner {
    public static void main(String[] args) {
        
        Address address = new Address(246,"Ghorpade peth" , "Pune", "411042");
        
        Customer customer = new Customer("Alam" , address);
        
        System.out.println(customer);
    }
}
public class Customer {
    private String name;
    private Address address;
    
    public Customer(String name, Address address) {
        this.name= name;
        this.address = address;
        
    }
    public void address() {
        this.address = address;
    }
    public String toString() {
        return "Name- " + name + " " + address;
    }
}
public class Address {
    private int flatNo;
    private String area;
    private String city;
    private String pincode;
    
    public Address(int flatNo, String area, String city, String pincode) {
        super();
        this.flatNo = flatNo;
        this.area = area;
        this.city = city;
        this.pincode = pincode;
    }
    public String toString() {
        return "\n" + "Address- " + flatNo + ", " + area + ", " + city + "-" + pincode; 
    }
}