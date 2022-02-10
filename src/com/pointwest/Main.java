package com.pointwest;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.pointwest.Util.*;

public class Main {

    public static void main(String[] args) {
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
                            "[6] Remove All Contacts",
                            "[7] Close app"};
        while (closeOptionCounter == 0){
            System.out.println("Options: " + String.join(" - ",options));
            System.out.println("=========================");
            System.out.println("What would you like to do?");
            try {
                choice = appScanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println(options[0]);
                        phonebook.getAllContacts();
                        break;
                    case 2:
                        System.out.println(options[1]);
                        System.out.println("Type 'exit' anytime to cancel the operation");
                        Contact newContact = populate();
                        if (newContact == null)
                            break;
                        contactMessageBuilder(phonebook.addContact(newContact));
                        break;
                    case 3:
                        System.out.println(options[2]);
                        System.out.println("Enter existing contact name to be updated");
                        System.out.println("Type 'exit' anytime to cancel the operation");
                        appScanner.nextLine();
                        try {
                            String nameToBeUpdated = appScanner.nextLine();
                            if(nameToBeUpdated.trim().equalsIgnoreCase("exit"))
                                break;
                            Contact contactToBeUpdated = phonebook.searchContact(nameToBeUpdated);
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
                        System.out.println(options[3]);
                        appScanner.nextLine();
                        System.out.println("Enter existing contact name to be deleted: ");
                        System.out.println("Type 'exit' anytime to cancel the operation");
                        try {
                            String nameToBeDeleted = appScanner.nextLine();
                            if(nameToBeDeleted.trim().equalsIgnoreCase("exit"))
                                break;
                            Contact contactToBeDeleted = phonebook.searchContact(nameToBeDeleted);
                            contactMessageBuilder(contactToBeDeleted);
                            System.out.println("Are you sure to remove contact above? (yes/no)" );
                            if(appScanner.nextLine().trim().equalsIgnoreCase("yes")){
                                Contact removedContact =  phonebook.deleteContact(contactToBeDeleted);
                                System.out.println("Contact with name: " + removedContact.getName() + " was successfully removed" );
                            }
                        }catch (NullPointerException e){
                            System.out.println("No contact found");
                        }
                        break;
                    case 5:
                        System.out.println(options[4]);
                        System.out.println("Type 'exit' anytime to cancel the operation");
                        System.out.println("Enter existing contact name");
                        appScanner.nextLine();
                        try {
                            String nameToBeSearched = appScanner.nextLine();
                            if(nameToBeSearched.trim().equalsIgnoreCase("Exit"))
                                break;
                            contactMessageBuilder(phonebook.searchContact(nameToBeSearched));
                        }catch (NullPointerException e){
                            System.out.println("No contact found");
                        }
                        break;
                    case 6:
                        System.out.println(options[5]);
                        System.out.println("Are you really sure to remove all contacts? (yes/no)" );
                        if(appScanner.nextLine().trim().equalsIgnoreCase("yes")){
                            phonebook.deleteAllContacts();
                        }

                        break;
                    case 7:
                        System.out.println(options[6]);
                        closeOptionCounter++;
                        break;
                    default:
                        System.out.println("Invalid input. Please choose from the options.");
                }
                System.out.println("Exiting to Menu");
            }catch (InputMismatchException e){
                System.out.println("Numbers only!");
                appScanner.nextLine();
            }
        }
    }


}
