package se.kth.iv1350.model;

import java.util.*;

import se.kth.iv1350.model.DTO.SaleDTO;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;
import java.time.LocalTime;
import java.time.LocalDate;

public class Sale {

	private ArrayList<Item> itemList;
	private double runningTotal;
	
	private String storeName = "ThatFoodStore";
	private String storeAdress = "ThatStoreAdress 69";
	private SaleDTO saleDTO;
	private DisplayDTO displayDTO;
	private RecieptDTO recieptDTO;
	private double change;

	private double totalVATPrice;

	public Sale() {
		itemList = new ArrayList<>();

	}

 /*
  * Calculates change and how much of the price is VAT to then create a reciept to return to the View so it can print out the reciept.	
  */
		
	public RecieptDTO createRecipt(double cash) {
		
		calculateChange(cash);
		calculateTotalVATPrice();

		RecieptDTO printReci = new RecieptDTO(storeName, storeAdress, itemList, runningTotal,
				totalVATPrice, LocalDate.now(), LocalTime.now(), cash, change);

		return printReci;
	}


	public boolean checkForExistingItem(int itemIdentifier) {

		Item existingItem = findItem(itemIdentifier);
		if(existingItem != null){
			return true;
		}
		else {
			return false;
		}
	}

	/*
	*
	* Adds currentItem to the itemList and sends the item to updateItemInSale to update quantity
	* and make the DisplayDTO that will be returned.
	*
	*/

	public DisplayDTO addNewItem(Item currentItem) {

		DisplayDTO informationToBeSentToDisplay = updateItemInSale(currentItem);
		itemList.add(currentItem);

		return informationToBeSentToDisplay;
	}

	/*
	*
	* Finds the them with the correct identifier and sends it to updateItemInSale to update quantity
	* and make a DisplayDTO.
	* Returns a DisplayDTO with relevant information for the customer.
	*
	*/
	public DisplayDTO addExistingItem(int itemIdentifier){

		Item searchedItem = findItem(itemIdentifier);

		DisplayDTO informationToBeSentToDisplay = updateItemInSale(searchedItem);

		return informationToBeSentToDisplay;
	}

	/*
	*
	* Searches for the item with the correctIdentifier
	*
	*/

	private Item findItem(int itemIdentifier){

		for (Item searchedItem : itemList){
			if(searchedItem.itemIdentifier == itemIdentifier){
				return searchedItem;
			}
		}
		return null;
	}

	/*
	*
	* Updates the quantity of currentItem and makes a DisplayDTO with relevant information.
	*
	*/

	private DisplayDTO updateItemInSale(Item currentItem){

		currentItem.quantity++;

		calculateRunningTotal(currentItem.itemPrice);
		DisplayDTO informationToBeSentToDisplay = new DisplayDTO(runningTotal, currentItem.itemVAT, currentItem.itemPrice, currentItem.itemName);

		return  informationToBeSentToDisplay;
	}


	public double getTotalPrice() {
		return runningTotal;
	}

	public SaleDTO getSaleDTO(int customerIdentification) {
		return null;
	}

	public void updateTotalPrice(int priceAfterDiscount) {

	}

	/*
	*
	* Updates the runningTotal with the price of the item currently being added.
	*
	*/

	private void calculateRunningTotal(double itemPrice) {
		runningTotal += itemPrice;

	}

	/*
	 * Takes the running total and reduses it with the cash given to the cashier to find out how much change the customer is suppose to get back. 
	 */
	private void calculateChange(double cash) {
		change = runningTotal - cash;
	}
	
	/*
	 * Calculates how much of the total price that the customer is paying is from VAT.
	 * By taking the price of the items from the itemList and multyplying it by the VAT and 0.01 (as the % is not saved in decimals)
	 */
	private void calculateTotalVATPrice(){
		totalVATPrice = 0;
		for (Item var : itemList) 
		{ 
		    totalVATPrice += var.itemPrice * var.itemVAT * 0.01;
		}
	}

	/*
	 * 
	 * Bellow this line are functions only used for testing
	 * 
	 * 
	 */


	public void setRunningTotal(double amountToSet) {
		runningTotal = amountToSet;
	}
	
	
	public double getChange() {
		
		return change;	
	}

}


