package mobilephone;

import java.util.ArrayList;


/**
 *
 * @author kristiyan
 */
public class Contacts {
    private final String name;
    private final String phoneNumber;
    private final ArrayList<String> contactList = new ArrayList<>();
    
    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public static Contacts contacts(String name, String phoneNumber) {
        return new Contacts(name, phoneNumber);
    }
    
    public ArrayList<String> getContact() {
        return contactList;
    }
    
    public void storeContact(String contact) {
        contactList.add(contact);
    }
    
    public void printContacts() {
        System.out.println("You have " + contactList.size() + " contacts in your list.");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(i + " - " + contactList.get(i));
        }
    }
}
