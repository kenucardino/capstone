package com.pointwest;

import java.util.ArrayList;
public class Phonebook implements Record{
    ArrayList<Contact> contacts = new ArrayList<>();

    public Phonebook() {
    }

    public Phonebook(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contact addContact(Contact contact){
        this.contacts.add(contact);
        int indexOfAddedContact = this.contacts.indexOf(contact);
        System.out.println("[Notification] New contact has been added");
        showContactMessageGenerator(this.contacts.get(indexOfAddedContact));
        return this.contacts.get(indexOfAddedContact);
    }

    public void getAllContacts(){
        System.out.println("[Notification] You have " + this.contacts.size() + " contact(s)");
        int counter = 1;
        for (Contact contact : this.contacts) {
//            showContactMessageGenerator(contact);
//            System.out.println("-----------------------");
            System.out.println(counter + ". Name: " + contact.name + " -  Phone number: " + contact.phoneNumber);
            counter++;
        }
    }
    public void showContactMessageGenerator(Contact contact) {
        System.out.println("Name: " + contact.getName());
        System.out.println("Address: " + contact.getAddress());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Phone Number: " + contact.getPhoneNumber());
    }


}
