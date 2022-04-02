import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class JUnitTest {

//    @BeforeEach //@AfterEach - запуск перед/после каждого теста
//    @RepeatedTest(3) - запуск метода 3 раза
//    @BeforeAll //@AfterAll - запуск перед/после всех тестов

    private final Calculator calc = Calculator.instance.get();

    @Test
    public void testString() {
        String original = "Original", argument = " argument";
        String expected = "Original argument";
        String result = original.concat(argument);
//        Assertions.assertEquals(expected, result);
        assertThat(expected, equalToIgnoringCase(result));
    }

    @Test
    public void testConstructorEquals_PhoneContact() {
        String name = "Friends";
        PhoneContact phoneContact = new PhoneContact(name);
        PhoneContact phoneContact1 = new PhoneContact(name);
//        Assertions.assertEquals(phoneContact, phoneContact1);
        assertThat(phoneContact, equalTo(phoneContact1));
    }

    @Test
    public void testEqualsObj_Contact () {
        Contact contact = new Contact("Alex", "007");
        Contact contact1 = new Contact("Alex", "111");
//        Assertions.assertEquals(contact, contact1);
        assertThat(contact, equalTo(contact1));
    }

    @Test
    public void testPrintContact_PhoneContact() {
        PhoneContact phoneContact = new PhoneContact("Friends");
        phoneContact.addContact("Alex", "007");
        phoneContact.addContact("Alex", "007");
        Assertions.assertEquals("- Friends" +
                "\n          - Alex 007", phoneContact.printPhoneContact());
    }

    @Test
    public void testSum_Calculator() {
        //arrange
        Integer a = 3, b = 2, expected = 5;
        //act
        Integer result = calc.plus.apply(a, b);
        //assert
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void testExeptionDivide_Calculator() {
        Integer a = 5, b = 0;
        Class<ArithmeticException> expected = ArithmeticException.class;
        Assertions.assertThrows(expected,
                () -> calc.divide.apply(a, b));
    }

}
