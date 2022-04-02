import java.util.*;

public class PhoneContact implements Comparable <PhoneContact>{
    private final String name;
    private Map<String, Set<Contact>> groupContacts = new HashMap<>();
    private Set<Contact> contacts = new HashSet<>();

    public PhoneContact(String name) {
        this.name = name;
        groupContacts.put(name, contacts);
    }

    public void addContact (String name, String number) {
        if (!contacts.add(new Contact(name, number))) {
            System.out.println("Данный контакт уже есть.");
        }
    }

    public String printPhoneContact () {
        String phoneContact = "- " + this.name;
        List<Contact> listContacts = new ArrayList<>(contacts);
        listContacts.sort(Contact::compareTo);
        for (Contact contact : listContacts) {
            phoneContact += "\n          - " + contact;
        }
        return phoneContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneContact that = (PhoneContact) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(PhoneContact o) {
        return this.name.compareTo(o.getName());
    }
}
