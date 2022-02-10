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

    @Override
    public Contact addContact(Contact contact){
        this.contacts.add(contact);
        int indexOfAddedContact = this.contacts.indexOf(contact);
        System.out.println("[Notification] New contact has been added");
        return this.contacts.get(indexOfAddedContact);
    }

    @Override
    public void getAllContacts(){
        System.out.println("[Notification] You have " + this.contacts.size() + " contact(s)");
        int counter = 1;
        for (Contact contact : this.contacts) {
            System.out.println(counter + ". Name: " + contact.getName() + " -  Phone number: " + contact.getPhoneNumber());
            counter++;
        }
    }

    @Override
    public Contact searchContact(String name) {
        for (Contact contact: this.contacts) {
            if (contact.getName().trim().equalsIgnoreCase(name.trim().toLowerCase())){
                System.out.println("[Notification] Contact Found");
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact updateContact(int index, Contact contact) {
        this.contacts.set(index,contact);
        Contact updatedContact = this.contacts.get(index);
        System.out.println("[Notification] Contact has been updated");
        return updatedContact;
    }

    @Override
    public Contact deleteContact(Contact contact) {
        this.contacts.remove(contact);
        return contact;
    }

    @Override
    public void deleteAllContacts() {
        this.contacts.clear();
        System.out.println("[Notification] Successfully removed all contacts. I hope you know what you are doing.");
    }
}
