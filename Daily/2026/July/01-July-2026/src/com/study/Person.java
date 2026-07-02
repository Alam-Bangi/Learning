package com.study;

public class Person {

    private String name;
    private long contactNumber;
    private String birthLocation;
    private Address address;

    public Person() {
    }

    public Person(String name, long contactNumber, String birthLocation, Address address) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.birthLocation = birthLocation;
        this.address = address;
    }

    public Person(String name, String contactNumber, String birthLocation, String address) {
        this.name = name;
        this.contactNumber = Long.parseLong(contactNumber);
        this.birthLocation = birthLocation;
        String[] attributes = address.split(", ");
        this.address = new Address(attributes[0],attributes[1],attributes[2],attributes[3],attributes[4]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static boolean isContactNumberValid(long contactNumber) {
        String contactNumberStr = String.valueOf(contactNumber);
        return contactNumberStr.length() == 10;
    }

    @Override
    public String toString() {
        return "\nName : " + name +
                "\nContact Number : " + contactNumber +
                "\nBirth Location : " + birthLocation +
                "\nAddress : " + address;
    }

    public String fileWrite(){
        String separator = " | ";
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(separator)
                .append(contactNumber).append(separator)
                .append(birthLocation).append(separator)
                .append(address).append("\n");
        return sb.toString();
    }

}