package tryouts.contactmanagement;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private HashMap<String, Contact> contacts = new HashMap<>();

    private boolean phoneExists(String phone, String excludeKey) {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (entry.getKey().equals(excludeKey)) {
                continue;
            }
            if (entry.getValue().getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public String addContact(String name, String phone) {
        if (!ContactValidator.isValidName(name)) {
            return "Name cannot be empty!";
        }
        if (!ContactValidator.isValidPhone(phone)) {
            return "Invalid phone number! Enter 10 digits.";
        }
        String key = ContactValidator.normalizeName(name);
        if (contacts.containsKey(key)) {
            return "Contact already exists!";
        }
        if (phoneExists(phone, null)) {
            return "Phone number already exists!";
        }
        contacts.put(key, new Contact(name.trim(), phone));
        return "Contact added successfully!";
    }

    public Contact searchContact(String name) {
        if (!ContactValidator.isValidName(name)) {
            return null;
        }
        String key = ContactValidator.normalizeName(name);
        return contacts.get(key);
    }

    public String updateContact(String name, String newPhone) {
        if (!ContactValidator.isValidName(name)) {
            return "Name cannot be empty!";
        }
        if (!ContactValidator.isValidPhone(newPhone)) {
            return "Invalid phone number!";
        }
        String key = ContactValidator.normalizeName(name);
        Contact contact = contacts.get(key);
        if (contact == null) {
            return "Contact not found!";
        }
        if (phoneExists(newPhone, key)) {
            return "Phone number already belongs to another contact!";
        }
        contact.setPhone(newPhone);
        return "Contact updated successfully!";
    }

    public String deleteContact(String name) {
        if (!ContactValidator.isValidName(name)) {
            return "Name cannot be empty!";
        }
        String key = ContactValidator.normalizeName(name);
        if (contacts.remove(key) != null) {
            return "Contact deleted successfully!";
        }
        return "Contact not found!";
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available!");
            return;
        }
        System.out.println("\n===== CONTACT LIST =====");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public int getContactCount() {
        return contacts.size();
    }
}
