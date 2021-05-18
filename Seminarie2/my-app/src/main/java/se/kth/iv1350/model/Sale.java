package se.kth.iv1350.model;

import java.util.*;

import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;
import se.kth.iv1350.model.DTO.SaleDTO;

import java.time.LocalTime;
import java.time.LocalDate;

/**
 * This class handles majority of the logistics for the sale.
 * It calculates prices and stores all the information of the current purchase
 *
 */

public class Sale {

	private ArrayList<Item> itemList;
	private double runningTotal;
	
	private String storeName = "ThatFoodStore";
	private String storeAdress = "ThatStoreAdress 69";
	private DisplayDTO displayDTO;
	private RecieptDTO recieptDTO;
	private double change;
	private List<SaleObserver> saleObservers = new ArrayList<>();

	private double priceBeforeDiscount;
	private double totalVATPrice;

	/**
	 * Creates a instance that represents the sale and instantiates the itemList.
	 *
	 */
	public Sale() {
		itemList = new ArrayList<>();


	}


	/**
	 * Calculates change and how much of the price is VAT to then create a reciept
	 * to return to the View so it can print out the reciept.
	 *
	 * Notifys observers that a payment has been completed.
	 *
	 * @param cash the amount paid
	 * @return receipt to be printed
	 * @throws Exception if amount paid is less then or equal to runningTotal
	 */
	public RecieptDTO createRecipt(double cash) throws Exception {
		
		calculateChange(cash);
		calculateTotalVATPrice();

		RecieptDTO printReci = new RecieptDTO(storeName, storeAdress, itemList, runningTotal,
				totalVATPrice, LocalDate.now(), LocalTime.now(), cash, change, (priceBeforeDiscount-runningTotal));
		
		notifyObservers();
		return printReci;
	}

	/**
	 * Notifys all observers that a change has been made.
	 */
	private void notifyObservers() {
	for(SaleObserver obs: saleObservers)
	{
		obs.newSale(runningTotal);
	}
	
}

	/**
	 * Checks if an item currently exists in the Sale.
	 *
 	 * @param itemIdentifier the identifier of the item being searched for
	 * @return a boolean with true if the item is found and false if it's not found
	 */

	public boolean checkForExistingItem(int itemIdentifier) {

		Item existingItem = findItem(itemIdentifier);
		if(existingItem != null){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds the new Item to the Sale and creates a displayDTO with information about
	 * the newItem and the current running total
	 *
	 * @param currentItem the new item being added to the sale
	 * @return displayDTO with information that will be displayed to the customer
	 */

	public DisplayDTO addNewItem(Item currentItem) {


		DisplayDTO informationToBeSentToDisplay = updateItemInSale(currentItem);
		itemList.add(currentItem);

		return informationToBeSentToDisplay;
	}

	/**
	 * Finds the item corresponding with the identifier in the sale and updates it's quantity.
	 * Then creates a DisplayDTO with information about the newItem and the current running total
	 *
	 * @param itemIdentifier the identifier of the item to update quantity of
	 * @return displayDTO with information that will be displayed to the customer
	 */
	public DisplayDTO addExistingItem(int itemIdentifier){

		Item searchedItem = findItem(itemIdentifier);

		DisplayDTO informationToBeSentToDisplay = updateItemInSale(searchedItem);

		return informationToBeSentToDisplay;
	}

	/**
	 * Searches for the item with the correct identifier
	 *
	 * @param itemIdentifier the identifier of the item being searched for
	 * @return the searched item or null if the item is not currently in the sale
	 */

	private Item findItem(int itemIdentifier){

		for (Item searchedItem : itemList){
			if(searchedItem.itemIdentifier == itemIdentifier){
				return searchedItem;
			}
		}
		return null;
	}

	/**
	 * Updates the quantity of currentItem and makes a DisplayDTO with relevant information.
	 *
	 * @param currentItem the item to get a updated quantity
	 * @return a displayDTO with information that will be displayed to the customer
	 */

	private DisplayDTO updateItemInSale(Item currentItem){

		currentItem.quantity++;

		calculateRunningTotal(currentItem.itemPrice);
		DisplayDTO informationToBeSentToDisplay = new DisplayDTO(runningTotal, currentItem.itemVAT, currentItem.itemPrice, currentItem.itemName);

		return  informationToBeSentToDisplay;
	}


	/**
	 * Sets priceBeforeDiscount to runningTotal in case there
	 * is no discount being asked for
	 *
	 * @return running total of the sale before discount
	 */
	public double endSale() {
		priceBeforeDiscount = runningTotal;
		return runningTotal;
	}


	/**
	 * Updates the runningTotal with the price of the item currently being added.
	 *
	 * @param itemPrice the price of the item being added to the sale
	 */

	private void calculateRunningTotal(double itemPrice) {
		runningTotal += itemPrice;

	}

	/**
	 * Creates a SaleDTO that will be used for calculating discount
	 *
	 * @param customerIdentification used for calculating discount later
	 * @return a SaleDTO with relevant information for the discount calculation
	 */

	public SaleDTO getSaleDTO(int customerIdentification) {

		SaleDTO saleInformation = new SaleDTO(itemList, customerIdentification, runningTotal);
		return saleInformation;
	}

	/**
	 * Updates sale with a new price after Discount
	 *
	 * @param priceAfterDiscount the new price of the sale
	 */

	public void updateTotalPrice(double priceAfterDiscount) {
		this.priceBeforeDiscount = runningTotal;
		this.runningTotal = priceAfterDiscount;
	}

	/**
	 * Takes the running total and reduces it with the cash
	 * given to the cashier to find out how much change the customer is supposed to get back.
	 *
	 * @param cash the amount paid by the customer
	 * @throws Exception when the amount paid is less then the total price
	 */
	private void calculateChange(double cash) throws Exception {

		if (cash < runningTotal){
			throw new Exception("Customer cash does not cover running total: " + cash);
		}
		change = cash - runningTotal;

	}

	/**
	 * Calculates how much of the total price that the customer is paying is from VAT.
	 * By taking the price of the items from the itemList and multiplying it by the VAT and
	 * 0.01 (as the % is not saved in decimals)
	 *
	 */
	private void calculateTotalVATPrice(){
		totalVATPrice = 0;
		for (Item var : itemList) 
		{ 
		    totalVATPrice += var.itemPrice - (var.itemPrice / var.itemVAT);
		}
	}

	public void setRunningTotal(double amountToSet) {
		runningTotal = amountToSet;
	}
	
	
	public double getChange() {
		
		return change;	
	}

	/**
	 * Adds all observers from Controller to Sale
	 *
	 * @param observers list of observers
	 */
	public void addSaleObservers(List<SaleObserver> observers) {
		saleObservers.addAll(observers);
	}

}


