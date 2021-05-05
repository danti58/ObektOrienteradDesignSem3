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
	private double priceAfterDiscount;
	private String storeName = "ThatFoodStore";
	private String storeAdress = "ThatStoreAdress 69";
	private SaleDTO saleDTO;
	private DisplayDTO displayDTO;
	private RecieptDTO recieptDTO;
	private double change;

	public Sale() {
		itemList = new ArrayList<>();

	}
	
		
	public RecieptDTO createReciept(int cash) {


		return null;
	}


	/*
	*
	* Checks if the item has already been added to the sale by comparing itemIdentifiers with
	* with Items in the itemList.
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
		return 0;
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

	public void calculateChange(double cash) {
		change = priceAfterDiscount - cash;
	}

	/*public int getItemInListQuantity(int itemIdentifier){
		return findItem(itemIdentifier).quantity;
	}*/


}
