package seedu.addressbook.data.person;

/**
 * Represents a person's postal code in the address 
 *
 */
public class PostalCode {

	private String postalCode_;
	
	public PostalCode(String postalCode){
		this.postalCode_ = postalCode;
	}
	
	public String getPostalCodeName(){
		return this.postalCode_;
	}
	
	@Override
	public boolean equals(Object other){
		return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.getPostalCodeName().equals(((PostalCode) other).getPostalCodeName())); // state check
	}
}
