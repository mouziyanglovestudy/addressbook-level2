package seedu.addressbook.data.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    /**
     * Test the method isSimilar in Name class.
     * @throws IllegalValueException
     */
    @Test
    public void isSimilar() throws IllegalValueException{
        
        Name tester;
        Name other;
        
        //if compare with null
        tester = new Name("Valid Name");
        assertFalse(tester.isSimilar(null));
        
        //if compare with a single letter
        tester = new Name("Valid Name");
        other = new Name("A");
        assertFalse(tester.isSimilar(other));
        
        //if compare with a complete different name with multiple parts
        tester = new Name("Valid Name");
        other = new Name("NUS CS");
        assertFalse(tester.isSimilar(other));
        
        //if compare with the same name
        tester = new Name("Valid Name");
        other = new Name("Valid Name");
        assertTrue(tester.isSimilar(other));
        
        //if compare with the same name with all lower case letters
        tester = new Name("Valid Name");
        other = new Name("valid name");
        assertTrue(tester.isSimilar(other));
        
        //if compare with the same name with all upper case letters
        tester = new Name("Valid Name");
        other = new Name("VALID NAME");
        assertTrue(tester.isSimilar(other));
    }
}
