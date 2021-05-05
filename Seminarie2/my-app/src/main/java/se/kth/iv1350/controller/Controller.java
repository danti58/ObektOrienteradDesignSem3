package se.kth.iv1350.controller;

import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.Discount;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;

public class Controller {

	private Sale sale;
	private Discount discount;
	private ExternalAccounting externalAccounting;
	private ExternalInventory externalInventory;

	public void startNewSale() {

	}

	/*
	*
	* Checks Sale if the item is already in Sale. If yes it updates the item quantity,
	* if not it gets the item from externalInventory and adds it to the sale. Returns the
	* values that needs to be displayed to the customer.
	*
	*/
	public DisplayDTO addItem(int itemIdentifier) throws Exception {

		boolean itemAlreadyAddedThisSale = sale.checkForExistingItem(itemIdentifier);
		DisplayDTO displayMessage;

		if (itemAlreadyAddedThisSale){
			displayMessage = sale.addExistingItem(itemIdentifier);
		}
		else {
			displayMessage = sale.addNewItem(externalInventory.getExistingItem(itemIdentifier));
		}
		return displayMessage;
	}

	public double endSale() {
		return 0;
	}

	public double checkForDiscount(int customerIdentification) {
		return 0;
	}

	public RecieptDTO paymentTransaction(int cash) {
		return null;
	}


	//Temporary, will be updated later
	public Controller() {
		sale = new Sale();
		externalInventory = new ExternalInventory();

	}

}
