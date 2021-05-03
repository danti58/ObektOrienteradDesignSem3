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
	
		
	public RecieptDTO createRecipt(int cash) {
		
		/*calculateChange(cash);
		

		RecieptDTO printReci = new RecieptDTO(storeName, storeAdress, itemList, totalPrice, discount,
				priceVAT, LocalDate.now(), LocalTime.now(), cash, change, priceAfterDiscount);*/

		return null;
	}


	/*Checks if the item has already been added to the sale by comparing itemIdentifiers with
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

	public DisplayDTO addNewItem(Item currentItem) {

		/*currentItem.quantity++;

		calculateRunningTotal(currentItem.itemPrice);
		DisplayDTO informationToBeSentToDisplay = new DisplayDTO(runningTotal, currentItem.itemVAT, currentItem.itemPrice, currentItem.itemName);
*/
		DisplayDTO informationToBeSentToDisplay = updateItemInSale(currentItem);
		itemList.add(currentItem);

		return informationToBeSentToDisplay;
	}

	public DisplayDTO addExistingItem(int itemIdentifier){

		Item searchedItem = findItem(itemIdentifier);

		DisplayDTO informationToBeSentToDisplay = updateItemInSale(searchedItem);


		return informationToBeSentToDisplay;
	}

	private Item findItem(int itemIdentifier){

		for (Item searchedItem : itemList){
			if(searchedItem.itemIdentifier == itemIdentifier){
				return searchedItem;
			}
		}
		return null;
	}

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


	private void calculateRunningTotal(double itemPrice) {
		runningTotal += itemPrice;

	}

	public void calculateChange(double cash) {
		change = priceAfterDiscount - cash;
	}



}
