class CustomerRunner {
    public static void main(String[] args) {
        
        Address homeAddress = new Address(246,"Ghorpade peth" , "Pune", "411042");
        
        Customer customer = new Customer("Alam" , homeAddress);
        Address workAddress = new Address(45, "Hinjewadi", "Pune", "411057");
        customer.setWorkAddress(workAddress);
        System.out.println(customer);
    }
}
class Customer {
    private String name;
    private Address homeAddress;
    private Address workAddress;
    
    public Customer(String name, Address homeAddress) {
        this.name= name;
        this.homeAddress = homeAddress;
        
    }
    public void homeAddress() {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
    public String toString() {
        return "Name- " + name + " " + homeAddress;
    }
}
class Address {
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
        String.format("name- [%s] homeAddress- [%s] workAddress- [%s]", name, homeAddress, workAddress);
    }
}