package seedu.addressbook.data.person;

/**
 * Represents a person's street in the address
 *
 */
public class Street {

	private String streetName_;
	
	public Street(String street){
		this.streetName_ = street;
	}
	
	public String getStreetName(){
		return this.streetName_;
	}
	
	@Override
	public boolean equals(Object other){
		return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.getStreetName().equals(((Street) other).getStreetName())); // state check
	}
}
