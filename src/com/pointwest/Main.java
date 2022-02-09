package com.pointwest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name;
        String address;
        String email;
        String phoneNumber;
        Phonebook phonebook = new Phonebook();
        phonebook.contacts.addAll(generateContacts());
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
                    System.out.println("Enter contact name: ");
                    appScanner.nextLine();
                    name = appScanner.nextLine();
                    System.out.println("Enter contact address: ");
                    address = appScanner.nextLine();
                    System.out.println("Enter contact email: ");
                    email = appScanner.nextLine();
                    System.out.println("Enter contact phone number: ");
                    phoneNumber = appScanner.nextLine();
                    Contact addedContact = phonebook.addContact(new Contact(name, address, email, phoneNumber));
                    break;
                case 3:
                    System.out.println("this is choice 3");
                    break;
                case 4:
                    System.out.println("this is choice 4");
                    break;
                case 5:
                    System.out.println("this is choice 5");
                    break;
                case 6:
                    System.out.println("this is choice 6");
                    closeOptionCounter++;
                    break;
            }
        }
    }

    public static ArrayList<Contact> generateContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Kenu Cardino","Manila","kenu.cardino@pointwest.com.ph","09837625152"));
        contacts.add(new Contact("Jograt Labingpito","Manila","jograt.labingpito@mail.com","09127362532"));
        contacts.add(new Contact("Jane Doe","Angeles, Pampanga","JaneDoe@ym.com","09287635162"));
        contacts.add(new Contact("John Smith","San Francisco","JSmith@any.com","092817463552"));
        return contacts;
    }
}
