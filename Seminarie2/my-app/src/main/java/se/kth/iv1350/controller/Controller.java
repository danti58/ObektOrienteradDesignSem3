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

	public DisplayDTO addItem(int itemIdentifier, int ItemQuantity) {
		return null;
	}

	public double endSale() {
		return 0;
	}

	public double checkForDiscount(int customerIdentification) {
		return 0;
	}

	
	public RecieptDTO paymentTransaction(double cash) {
		
		
		RecieptDTO printReci = sale.createRecipt(cash);
		externalAccounting.updateAccounting(printReci);			
		externalInventory.updateInventory(printReci);
		
		
		
		return printReci;
	}

	public Controller Controller() {
		return null;
	}

}
