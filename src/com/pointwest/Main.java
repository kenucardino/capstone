package com.pointwest;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pointwest.Util.*;

public class Main {

    public static void main(String[] args) {
        String name;
        String address;
        String email;
        String phoneNumber;
        Phonebook phonebook = new Phonebook();
        phonebook.contacts.addAll(generateContacts());
        System.out.println("Generated four initial contacts");
        int closeOptionCounter = 0;
        Scanner appScanner = new Scanner(System.in);
        int choice;
        String[] options = {"[1] Display Contacts",
                            "[2] Add contact",
                            "[3] Update Contact",
                            "[4] Remove Contact",
                            "[5] Search Contact",
                            "[6] Close app"};
        while (closeOptionCounter == 0){
            System.out.println("Options: " + String.join(" - ",options));
            System.out.println("=========================");
            System.out.println("What would you like to do?");
            choice = appScanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("[Display Contacts]");
                    phonebook.getAllContacts();
                    break;
                case 2:
                    System.out.println("[Add Contact]");
                    Contact newContact = populate();
                    contactMessageBuilder(phonebook.addContact(newContact));
                    break;
                case 3:
                    System.out.println("[Update Contact]");
                    System.out.println("Enter existing contact name to be updated");
                    appScanner.nextLine();
                    try {
                        Contact contactToBeUpdated = phonebook.searchContact(appScanner.nextLine());
                        contactMessageBuilder(contactToBeUpdated);
                        int index = phonebook.contacts.indexOf(contactToBeUpdated);
                        System.out.println("[Notification] Enter values to fields for the update: ");
                        Contact updatedContact = populate();
                        contactMessageBuilder(phonebook.updateContact(index, updatedContact));
                    }catch (NullPointerException e){
                        System.out.println("No contact found");
                    }
                    break;
                case 4:
                    System.out.println("[Remove Contact]");
                    appScanner.nextLine();
                    System.out.println("Enter existing contact name to be deleted: ");
                    try {
                        Contact contactToBeDeleted = phonebook.searchContact(appScanner.nextLine());
                        contactMessageBuilder(contactToBeDeleted);
                        System.out.println("Are you sure to delete contact above?" );
                        if(appScanner.nextLine().trim().equalsIgnoreCase("yes")){
                            Contact removedContact =  phonebook.deleteContact(contactToBeDeleted);
                            System.out.println("Contact with name: " + removedContact.getName() + "was successfully removed" );
                        }
                    }catch (NullPointerException e){
                        System.out.println("No contact found");
                    }
                    break;
                case 5:
                    System.out.println("[Search Contact]");
                    System.out.println("Enter existing contact name");
                    appScanner.nextLine();
                    try {
                        contactMessageBuilder(phonebook.searchContact(appScanner.nextLine()));
                    }catch (NullPointerException e){
                        System.out.println("No contact found");
                    }
                    break;
                case 6:
                    System.out.println("this is choice 6");
                    closeOptionCounter++;
                    break;
            }
            System.out.println("Exiting to Menu");
        }
    }


}
