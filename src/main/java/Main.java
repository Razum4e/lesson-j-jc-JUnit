/* не понял как так сделал там, где есть to do
* и не понял как работает Collections.binarySearch(list, key);
* ведь нужно было по нему сделать эту самую сортировку
* хотя хотел сделать PriorityQueue
* и не понятно как работает compareTo
 */

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Set<PhoneContact> phoneContacts = new HashSet<>();
        System.out.println("Запущена программа справочник. v1.0");
        System.out.println("Создать группу контактов."+
                "\n(введите название)");
        String line = scanner.nextLine();
        phoneContacts.add(new PhoneContact(line));
        while (true) {
            System.out.println("Создать еще одну группу контактов?"+
                    "\n(введите название или \"нет\")");
            line = scanner.nextLine();
            if (line.equals("нет")) {
                break;
            } else if (!phoneContacts.add(new PhoneContact(line))) {
                System.out.println("Такая группа контактов уже есть.\n");
            }
        }
        printPhoneContact(phoneContacts);
        while (true) {
            System.out.println("Создать контакт?" +
                    "\n(введите имя контакта и через пробел номер контакта (+7ХХХ) или \"нет\")");
            line = scanner.nextLine();
            if (line.equals("нет")) break;
            String[] splitContact = line.split("\\+");
            System.out.println("Введите через пробел группы контактов: ");
            line = scanner.nextLine();
            String[] groups = line.split(" ");
            for (String group : groups) {
                if (phoneContacts.contains(new PhoneContact(group))) {
                    findContact(new PhoneContact(group), phoneContacts).addContact(splitContact[0], "+" + splitContact[1]);
                }
            }
        }
        printPhoneContact(phoneContacts);
    }
    public static void printPhoneContact (Set<PhoneContact> phoneContacts) {
        System.out.println("Справочник контактов:");
        List<PhoneContact> listPhoneContacts = new ArrayList<>(phoneContacts);
        listPhoneContacts.sort(PhoneContact::compareTo);
        for (PhoneContact contact : listPhoneContacts) {
            System.out.println(contact.printPhoneContact());
        }
    }
    public static PhoneContact findContact(PhoneContact source, Set<PhoneContact> phoneContacts)
    {
        if (phoneContacts.contains(source)) {
            for (PhoneContact obj : phoneContacts) {
                if (obj.equals(source))
                    return obj;
            }
        }
        return null;
    }
}
