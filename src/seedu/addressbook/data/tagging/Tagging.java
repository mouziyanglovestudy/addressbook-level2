package seedu.addressbook.data.tagging;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
    
    private Person person;
    private Tag tag;
    private String operation;
    
    private static final String ADD_OPERAION = "+";
    private static final String REMOVE_OPERATION = "-";
    
    /**
     * Initialize Tagging
     * 
     * @param person in this tagging
     * @param tag in this tagging
     * @param operation: whether "-" or "+"
     */
    public Tagging(Person person, Tag tag, String operation){
        if(isValidOperation(operation)){
            this.person = person;
            this.tag = tag;
            this.operation = operation;
        }
    }
    
    public Person getPerson(){
        return this.person;
    }
    
    public Tag getTag(){
        return this.tag;
    }
    
    public String getOperation(){
        return this.operation;
    }
    
    /**
     * Check if the operation is valid (either "+" or "-")
     * @param operation
     * @return whether the operation is valid
     */
    private boolean isValidOperation(String operation){
        if(operation.equals(ADD_OPERAION) || operation.equals(REMOVE_OPERATION)){
            return true;
        }
        return false;
    }
}
