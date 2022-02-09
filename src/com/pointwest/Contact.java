package com.pointwest;


public class Contact extends Person{
    private String email, phoneNumber;
    public Contact(){

    }

    public Contact(String name, String address, String email, String phoneNumber) {
        super(name, address);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
