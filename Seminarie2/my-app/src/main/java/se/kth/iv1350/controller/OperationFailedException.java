package se.kth.iv1350.controller;

public class OperationFailedException extends Exception {

    public OperationFailedException(String messageToUser){
        super(messageToUser);
    }
}
