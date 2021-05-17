package se.kth.iv1350.model.DTO;

import se.kth.iv1350.model.Item;

import java.util.*;

public class SaleDTO {

    private ArrayList<Item> itemList;
    private int customerIdentification;
    private double runningTotal;

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