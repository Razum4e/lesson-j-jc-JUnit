import java.util.Objects;

public class Contact implements Comparable<Contact>{
    private final String name;
    private final String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return name + " " + number;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.getName());
    }
}
