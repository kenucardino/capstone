package com.pointwest;

public interface Record {
    Contact addContact(Contact contact);
    void getAllContacts();
    Contact searchContact(String name);
    Contact updateContact(int index, Contact contact);
    Contact deleteContact(Contact contact);
}
