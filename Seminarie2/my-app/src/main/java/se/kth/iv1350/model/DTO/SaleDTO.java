package se.kth.iv1350.model.DTO;

import se.kth.iv1350.model.Item;

import java.util.*;

/**
 * A data transfer object with information relevant for calculating discount
 *
 */
public class SaleDTO {

    private ArrayList<Item> itemList;
    private int customerIdentification;
    private double runningTotal;

    /**
     * Creates a new instance containing information relevant for calculating discount
     *
     * @param itemList list of items in the sale
     * @param customerIdentification identification of the customer
     * @param runningTotal total price of the sale before discount
     */
    public SaleDTO(ArrayList itemList, int customerIdentification, double runningTotal) {
        this.itemList = itemList;
        this.customerIdentification = customerIdentification;
        this.runningTotal = runningTotal;
    }

    public int getCustomerIdentification(){
        return this.customerIdentification;
    }

    public ArrayList getItemList(){
        return this.itemList;
    }

    public double getRunningTotal(){
        return this.runningTotal;
    }

}