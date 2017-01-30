package seedu.addressbook.data.person;

/**
 * Represents a person's unit in the address
 *
 */
public class Unit {
	
	private String unitName_;
	
	public Unit(String unit){
		this.unitName_ = unit;
	}
	
	public String getUnitName(){
		return this.unitName_;
	}
	
	@Override
	public boolean equals(Object other){
		return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.getUnitName().equals(((Unit) other).getUnitName())); // state check
	}
}
