package se.kth.iv1350.dbHandler;

public class ExternalInventoryException extends Exception {

    public ExternalInventoryException(String relevantErrorInformation){

        super(relevantErrorInformation);
    }

}
