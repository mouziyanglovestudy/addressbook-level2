package seedu.addressbook.data.person;

/**
 * Represents a person's block in the address
 *
 */
public class Block {
	
	private String blockName_;
	
	public Block(String block){
		this.blockName_ = block;
	}
	
	public String getBlockName(){
		return this.blockName_;
	}
	
	@Override
	public boolean equals(Object other){
		return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.getBlockName().equals(((Block) other).getBlockName())); // state check
	}
}
