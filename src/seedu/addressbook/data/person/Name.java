package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;
    private final List<String> segmentsList; 

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = trimName(name);
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
        this.segmentsList = convertNameIntoSegmentsList(trimmedName);
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if ...
     */
     public boolean isSimilar(Name other) {
         if (other == null) {
             return false;
         } else {
             return listContain(this.segmentsList, other.segmentsList);
         }
     }
     
     /**
      * Return if there is containing relationship between two lists
      * 
      * @param a
      * @param b
      * @return a contains b or b contains a
      */
     private <E> boolean listContain(List<E> a, List<E> b){
         return a.containsAll(b) || b.containsAll(a);
     }

     /**
      * Remove punctuation and leading spaces of a string
      * 
      * @param name
      * @return name without punctuation and leading spaces
      */
     private String trimName(String name) {
         String trimmedName = name.trim();
         trimmedName = trimmedName.replace(",", "");
         trimmedName = trimmedName.replace(".", "");
         return trimmedName;
     }
     
     /**
      * Store segments of a name in a list
      * @param trimmedName
      * @return a list of name segments
      */
     private List<String> convertNameIntoSegmentsList(String trimmedName) {
         String[] nameSegments = this.fullName.toLowerCase().split(" ");
         Arrays.sort(nameSegments);
         return Arrays.asList(nameSegments);
     }

}
