package com.pointwest;

import java.util.ArrayList;
import java.util.Scanner;

public class Util {
    static String  name;
    static String address;
    static String email;
    static String phoneNumber;
    public static void contactMessageBuilder(Contact contact) {
        System.out.println("Name: " + contact.getName());
        System.out.println("Address: " + contact.getAddress());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Phone Number: " + contact.getPhoneNumber());
    }

    public static ArrayList<Contact> generateContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Kenu Cardino","Manila","kenu.cardino@pointwest.com.ph","09837625152"));
        contacts.add(new Contact("Jograt Labingpito","Manila","jograt.labingpito@mail.com","09127362532"));
        contacts.add(new Contact("Jane Doe","Angeles, Pampanga","JaneDoe@ym.com","09287635162"));
        contacts.add(new Contact("John Smith","San Francisco","JSmith@any.com","092817463552"));
        return contacts;
    }

    public static Contact populate(){
        Scanner appScanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Enter contact name: ");
        name = appScanner.nextLine();
        if(name.trim().equalsIgnoreCase("exit"))
            return null;
        contact.setName(name.trim());
        System.out.println("Enter contact address: ");
        address = appScanner.nextLine();
        if(address.trim().equalsIgnoreCase("exit"))
            return null;
        contact.setAddress(address.trim());
        System.out.println("Enter contact email: ");
        email = appScanner.nextLine();
        if(email.trim().equalsIgnoreCase("exit"))
            return null;
        contact.setEmail(email.trim());
        System.out.println("Enter contact phone number: ");
        phoneNumber = appScanner.nextLine();
        if(phoneNumber.trim().equalsIgnoreCase("exit"))
            return null;
        contact.setPhoneNumber(phoneNumber.trim());
        return contact;
    }


}
