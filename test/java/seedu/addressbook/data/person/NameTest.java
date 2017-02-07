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
        
        //if compare with null
        Name tester = new Name("Valid Name");
        assertFalse(tester.isSimilar(null));
    }
}
