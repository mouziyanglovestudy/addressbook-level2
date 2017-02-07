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
    }
}
