package se.kth.iv1350.dbHandler;

/**
 * Throws when trying to add a Item that does not exist.
 */

public class ItemNotFoundException extends Exception {

    /**
     * Creates a new instance with a message describing what failed and which identifier could not be found
     *
     * @param errorMessage message describing the failure
     * @param itemIdentifier the identifier that could not be found
     */
    public ItemNotFoundException (String errorMessage,int itemIdentifier) {
        super(errorMessage + " " + itemIdentifier);
    }
}
