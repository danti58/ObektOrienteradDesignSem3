package se.kth.iv1350.model.DTO;

import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * Stores all information that is relevant for the customer
 *
 */
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

	private double discount;


	/**
	 * Creates a new instance representing the information relevant for the customer
	 *
	 * @param storeNameIn the name of the store
	 * @param storeAdressIn the address of the store
	 * @param itemListIn list of items in the sale
	 * @param runningTotalIn the final price of the sale
	 * @param totalVATPriceIn the total vat of the sale
	 * @param dateIn the current date
	 * @param timeIn the current time
	 * @param cashIn amount paid by the customer
	 * @param changeIn the amount to give to the customer
	 * @param discountIn the amount of discount the customer has received
	 */
	public RecieptDTO (String storeNameIn, String storeAdressIn, ArrayList itemListIn, double runningTotalIn, double totalVATPriceIn, LocalDate dateIn, LocalTime timeIn, double cashIn, double changeIn, double discountIn) {
		
		storeName = storeNameIn;
		storeAdress = storeAdressIn;
		itemList = itemListIn;
		totalPrice = runningTotalIn;
		totalVATPrice = totalVATPriceIn;
		date = dateIn;
		time = timeIn;
		cash = cashIn;
		change = changeIn;
		discount = discountIn;
	}


	/**
	 * String representation of the receipt
	 *
	 * @return string representation of the receipt
	 */
    public String toString(){
        return storeName + "\n"  + 
        		storeAdress + "\n" +
        		date + "\n"  + 
        		time + "\n" +
        		itemList + "\n" +
        		"total price " + totalPrice + "\n" +
        		"total VAT price " + String.format("%.2f",totalVATPrice) + "\n" +
        		"payed amount " + cash + "\n" +
        		"money back " + change + "\n" +
        		"discount " + discount + "\n";
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