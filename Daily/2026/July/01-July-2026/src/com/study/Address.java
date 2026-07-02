package com.study;

public class Address {

    private int flatNo;
    private String streetName;
    private String city;
    private String state;
    private int pincode;

    public Address() {
    }

    public Address(int flatNo, String streetName, String city, String state, int pincode) {
        this.flatNo = flatNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public Address(String flatNo, String streetName, String city, String state, String pincode) {
        this.flatNo = Integer.parseInt(flatNo);
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.pincode = Integer.parseInt(pincode.trim());
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return flatNo + ", " + streetName + ", " + city + ", " + state + ", " + pincode ;
    }
}