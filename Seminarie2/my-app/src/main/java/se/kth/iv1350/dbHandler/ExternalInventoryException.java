package se.kth.iv1350.dbHandler;

/**
 * Throws when there is a problem with communication with the database.
 */

public class ExternalInventoryException extends Exception {

    /**
     * New instance with message describing why the method failed
     *
     * @param relevantErrorInformation information about the problem (In this case the hardcoded communication fail with the database)
     */
    public ExternalInventoryException(String relevantErrorInformation){

        super(relevantErrorInformation);
    }

}
