package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #00-00, 000000";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTAL_CODE_INDEX = 3;

    private final Block block_;
    private final Unit unit_;
    private final Street street_;
    private final PostalCode postalCode_;
    
    private final String value_;
    
    private boolean isPrivate;

    /**
     * Validates given address. e.g. a/BLOCK, STREET, UNIT, POSTAL_CODE
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String[] splittedAddress = address.split(",");
        value_ = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(value_)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block_ = new Block(splittedAddress[BLOCK_INDEX].trim());
        this.street_ = new Street(splittedAddress[STREET_INDEX].trim());
        this.unit_ = new Unit(splittedAddress[UNIT_INDEX].trim());
        this.postalCode_ = new PostalCode(splittedAddress[POSTAL_CODE_INDEX].trim());
    }

    public Block getBlock(){
    	return this.block_;
    }
    
    public Street getStreet(){
    	return this.street_;
    }
    
    public Unit getUnit(){
    	return this.unit_;
    }
    
    public PostalCode getPostalCode(){
    	return this.postalCode_;
    }
    
    public String getValue(){
    	return this.value_;
    }
    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value_;
        }

    @Override
    public boolean equals(Object other) {
    	if(other == this){
    		return true;
    	} else if(other instanceof Address){
    		if(this.getBlock().equals(((Address) other).getBlock())){
    			if(this.getUnit().equals(((Address) other).getUnit())){
    				if(this.getStreet().equals(((Address) other).getStreet())){
    					if(this.getPostalCode().equals(((Address) other).getPostalCode())){
    						return true;
    					}
    				}
    			}
    		}
    	} else{
    		return false;
    	}
		return false;
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
