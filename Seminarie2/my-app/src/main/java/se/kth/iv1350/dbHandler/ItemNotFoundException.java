package se.kth.iv1350.dbHandler;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException (String errorMessage,int itemIdentifier) {
        super(errorMessage + " " + itemIdentifier);
    }
}
