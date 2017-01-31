package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class Formatter {

	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    public static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    public static final String LS = System.lineSeparator();

    public static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    public static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /**
     * Get the welcome message.
     * 
     * @param version
     * @param storageFilePath
     * @return welcome message
     */
    public String getWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return DIVIDER + DIVIDER + MESSAGE_WELCOME + version +
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE + storageFileInfo + DIVIDER;
    }

    /**
     * Get goodbye message
     * 
     * @return goodbye message
     */
    public String getGoodbyeMessage() {
        return MESSAGE_GOODBYE + DIVIDER + DIVIDER;
    }

    /**
     * 
     * @return initialization failure message
     */
    public String getInitFailedMessage() {
        return MESSAGE_INIT_FAILED + DIVIDER + DIVIDER;
    }
    
    /**
     * helper method in showToUser
     * 
     * @param m
     * @return the format in the showToUser function
     */
    public String getShowToUserFormat(String m){
    	return LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX);
    }
    
    /** get message of InstructionOfEnterCommand */
    public String getEnterCommandMessage(){
    	return LINE_PREFIX + "Enter command: ";
    }
    
    /** get message of ResultOfEnterCommandMessage */
    public String getEnterCommandResultMessage(String fullInputLine){
    	return "[Command entered:" + fullInputLine + "]";
    }
    
    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    public List<String> formatPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formattedPersons;
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
