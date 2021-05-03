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
	
	
		
	public RecieptDTO createRecipt(double cash) {
		
		calculateChange(cash);
		calculateTotalVATPrice();

		RecieptDTO printReci = new RecieptDTO(storeName, storeAdress, itemList, runningTotal,
				totalVATPrice, LocalDate.now(), LocalTime.now(), cash, change);

		return printReci;
	}
	
	
	
	public Sale() {
        itemList = new ArrayList<>();

    }
	public boolean checkForExistingItem(int itemIdentifier) {
		return false;
	}

	public DisplayDTO updateItemQuantity(int itemQuantity, int itemIdentifier) {
		return null;
	}

	public DisplayDTO addNewItem(Item currentItem) {

		currentItem.quantity++;
		itemList.add(currentItem);
		return null;
	}

	public double getTotalPrice() {
		return 0;
	}

	public SaleDTO getSaleDTO(int customerIdentification) {
		return null;
	}

	public void updateTotalPrice(int priceAfterDiscount) {

	}


	private void calculateRunningTotal() {

	}

	private void calculateChange(double cash) {
		change = runningTotal - cash;
	}
	
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


