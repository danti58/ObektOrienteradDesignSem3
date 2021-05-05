package se.kth.iv1350.model.DTO;

import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class RecieptDTO {

	private String storeName;

	private String storeAdress;

	private ArrayList itemList;

	private double totalPrice;

	private double totalVATPrice;

	private LocalDate date;

	private LocalTime time;

	private double cash;

	private double change;

	public RecieptDTO (String storeNameIn, String storeAdressIn, ArrayList itemListIn, double runningTotalIn, double totalVATPriceIn, LocalDate dateIn, LocalTime timeIn, double cashIn, double changeIn) {
		
		storeName = storeNameIn;
		storeAdress = storeAdressIn;
		itemList = itemListIn;
		totalPrice = runningTotalIn;
		totalVATPrice = totalVATPriceIn;
		date = dateIn;
		time = timeIn;
		cash = cashIn;
		change = changeIn;
	}


/*
 * 
 * 
 * under this line is the testing gets, not used for the real profram
 */
	
    public String toString(){
        return storeName + "\n"  + 
        		storeAdress + "\n" +
        		date + "\n"  + 
        		time + "\n" +
        		itemList + "\n" +
        		"total price" + totalPrice + "\n" +
        		"total VAT price" + String.format("%.2f",totalVATPrice) + "\n" +
        		"payed ammount" + cash + "\n" +
        		"mony back" + change + "\n";
    }

	
	public String getStoreName() {
		return storeName;
		
	}
	
	public String getStoreAdress() {
		return storeAdress;
	}
	
	public ArrayList getItemList(){
		return itemList;
	}
	
	public double getTotalPrice(){
		return totalPrice;
	}
	
	public double getTotalVATPrice() {
		return totalVATPrice;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public double getCash() {
		return cash;
	}
	
	public double getChange() {
			return change;
	}
}