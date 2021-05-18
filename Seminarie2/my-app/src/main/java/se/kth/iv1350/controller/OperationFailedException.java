package se.kth.iv1350.controller;

/**
 * Exception used when there is a error with the system
 *
 */
public class OperationFailedException extends Exception {

    /**
     * The exception sent to the user when there is a system error
     *
     * @param messageToUser the message displayed to the user
     */
    public OperationFailedException(String messageToUser){
        super(messageToUser);
    }
}
