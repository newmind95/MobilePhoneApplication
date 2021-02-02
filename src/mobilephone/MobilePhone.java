package mobilephone;

// Create a program that implements a simple mobile phone with the following capabilities.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.

/**
 *
 * @author kristiyan
 */
public class MobilePhone {
    private  ArrayList<Contacts> contactList = new ArrayList<>();
    
   
    public boolean addContact(Contacts contact) {
        if (searchForContact(contact.getName()) > 0) {
            System.out.println("Contact already exist in the list.");
        }
        contactList.add(contact);
        return true;
    }
    
    private int searchForContact(Contacts contact) {
        return this.contactList.indexOf(contact);
    }
    
    private int searchForContact(String contact) {
        for (int i = 0; i < contactList.size(); i++) {
            Contacts contacts = this.contactList.get(i);
            if (contacts.getName().equals(contact)) {
                return i;
            }
        }
        return 0;
    }
    
    public boolean isContactUpdated(Contacts oldContact, Contacts newContact) {
        int foundPosition = searchForContact(oldContact);
    
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        this.contactList.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with: " + newContact.getName());
        return true;
    }
    
    public boolean isContactRemoved(Contacts contact) {
        int findContact = searchForContact(contact);
        if (findContact < 0) {
            return false;
        }
        this.contactList.remove(findContact);
        return true;
    }
    
    public String queryContact(Contacts contact) {
        if (searchForContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }
    
    public Contacts queryContact(String name) {
        int position = searchForContact(name);
        if (position >= 0) {
            return contactList.get(position);
        }
        return null;
    }
}
