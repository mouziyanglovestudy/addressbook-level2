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
        
        //if compare with the same name with mix case letters
        tester = new Name("Valid Name");
        other = new Name("vALID nAME");
        assertTrue(tester.isSimilar(other));
        
        //if compare with the same name but different orders
        tester = new Name("Valid Name");
        other = new Name("Name Valid");
        assertTrue(tester.isSimilar(other));
        
        //if compare with the same name but different orders and case letters
        tester = new Name("Valid Name");
        other = new Name("nAME vALID");
        assertTrue(tester.isSimilar(other));
        
        //if compare with the same name but adding comma inside
        tester = new Name("Valid Name");
        other = new Name("Valid, Name");
        assertTrue(tester.isSimilar(other));
        
        //if compare with the name containing more segments
        tester = new Name("Valid Name");
        other = new Name("Valid Name Plus");
        assertTrue(tester.isSimilar(other));
        
        //if compare with the name containing less segments
        tester = new Name("Valid Name");
        other = new Name("Valid");
        assertTrue(tester.isSimilar(other));
        
        //if compare with different name but has overlap
        tester = new Name("Valid Name Jr");
        other = new Name("Valid Name Sr");
        assertFalse(tester.isSimilar(other));

    }
}
