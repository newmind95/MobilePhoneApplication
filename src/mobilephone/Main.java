package mobilephone;

import java.util.Scanner;

/**
 *
 * @author kristiyan
 */
public class Main {
        private static Scanner input = new Scanner(System.in);
        private static MobilePhone phoneContacts = new MobilePhone();
        private static final Contacts contacts = new Contacts("Kristiyan Penev", "0876757947");
    
    /** Main method. */
    public static void main(String[] args) {
        boolean isQuit = false;
        int choice = 0;
        printInstructions();
        while (!isQuit) {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    phoneContacts.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeExistingContact();
                    break;
                case 5:
                    searchForExistingContact();
                    break;
                case 6:
                    isQuit = true;
                    break;
            }
        }
    }
    
    /** Method to print the instructions. */
     protected static void printInstructions() {
        System.out.println("\t 0 to print the choice options: ");
        System.out.println("\t 1 to print the Contact list: ");
        System.out.println("\t 2 to add a contact in the contact list: ");
        System.out.println("\t 3 to modify a contact: ");
        System.out.println("\t 4 to remove existing contact: ");
        System.out.println("\t 5 to search for existing contact: ");
        System.out.println("\t 6 to quit from the application: ");
    }
    
    /** Method to add contact in the list. */
    protected static void addContact() {
        System.out.println("Dialog for creating a contact: ");
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = input.nextLine();
        Contacts addNewContact = Contacts.contacts(name, phoneNumber);
        if (phoneContacts.addContact(addNewContact)) {
            System.out.println("Created new contact. Name: " + name + ", Phone Number: " + phoneNumber);
        } else {
            System.out.println("Could not create a contact!");
        }
    }
    
    /** Method to update existing contact. */
    protected static void modifyContact() { 
        System.out.println("Please enter contact you want to modify: ");
        System.out.print("Enter contact Name: ");
        String name = input.nextLine();
        Contacts existingContact = phoneContacts.queryContact(name);
        if (existingContact == null) {
            System.out.println("Could not find the contact.");
        }
        System.out.println("Please enter new name and new phone number: ");
        System.out.print("Enter contact new name: ");
        String newName = input.nextLine();
        System.out.print("Enter contact new phone number: ");
        String newPhoneNumber = input.nextLine();
        Contacts modifyExistingContact = Contacts.contacts(newName, newPhoneNumber);
        if (phoneContacts.isContactUpdated(existingContact, modifyExistingContact)) {
            System.out.println("Successful modify contact: " + newName);
        } else {
            System.out.println("Could not modify contact!");
        }
    }
    
    /** Method to remove existing contact from the list. */
    protected static void removeExistingContact() {
        System.out.println("Please enter contact you want to delete: ");
        System.out.print("Enter contact name: ");
        String existingName = input.nextLine();
        System.out.print("Enter contact phone number: ");
        String phoneNumber = input.nextLine();
        Contacts removeExistingContact = phoneContacts.queryContact(existingName);
        if (phoneContacts.isContactRemoved(removeExistingContact)) {
            System.out.println("Successful delete contact: " + existingName);
        } else {
            System.out.println("Could not delete contact!" + existingName);
        }
    }

    /** Method to search for existing contact in the list. */
    protected static void searchForExistingContact() {
       System.out.println("Please enter contact you want to find: ");
       System.out.print("Enter name: ");
       String name = input.nextLine();
       Contacts searchContact = phoneContacts.queryContact(name);
       if (searchContact != null) {
           System.out.println("Find " + searchContact.getName() + " in your contact list.");
       } else {
           System.out.println("Could not find contact in your list!");
       }   
    }
}
