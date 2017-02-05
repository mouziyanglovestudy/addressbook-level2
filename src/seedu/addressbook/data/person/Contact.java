package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

        private boolean isPrivate;
        public String value;
        
        public Contact(String contact, boolean isPrivate) throws IllegalValueException {
            this.isPrivate = isPrivate;
            String trimmedcontact = contact.trim();
            this.value = trimmedcontact;
        }
        
        /**
         * Test whether the string is a valid input.
         * 
         * @param test String
         * @return whether the string matches the regular expression
         */
        
        @Override
        public boolean equals(Object other) {
            return other == this // short circuit if same object
                    || (other instanceof Contact // instanceof handles nulls
                    && this.value.equals(((Contact) other).value)); // state check
        }
        
        @Override
        public String toString() {
            return value;
        }
        
        @Override
        public int hashCode() {
            return value.hashCode();
        }
        
        public boolean isPrivate() {
            return isPrivate;
        }
}
