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

    @Override
    public String toString() {
        return "\nName : " + name +
                "\nContact Number : " + contactNumber +
                "\nBirth Location : " + birthLocation +
                "\nAddress : " + address;
    }

}