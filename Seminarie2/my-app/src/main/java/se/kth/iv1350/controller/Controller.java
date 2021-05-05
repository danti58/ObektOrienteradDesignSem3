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


	public Controller(ExternalInventory externalInventoryIn, ExternalAccounting externalAccountingIn) {
		externalInventory = externalInventoryIn;
		externalAccounting = externalAccountingIn;

	}

	public void startNewSale() {
		sale = new Sale();
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

	/*
	 * gets the total price from sale, and gives it to the view so the cashier can tell the customer what the cost is
	 */
	public double endSale() {
		return sale.getTotalPrice();
	}

	public double checkForDiscount(int customerIdentification) {
		return 0;
	}

	/*
	 * 
	 * Gets all the imporant information from sale for the recipt and returns it to the viw as a DTO
	 * 
	 */
	public RecieptDTO paymentTransaction(double cash) {
		
		
		RecieptDTO printReci = sale.createRecipt(cash);
		externalAccounting.updateAccounting(printReci);			
		externalInventory.updateInventory(printReci);
		
		sale = null;
		
		return printReci;
	}


}
