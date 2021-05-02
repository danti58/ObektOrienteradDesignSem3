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

	public DisplayDTO addItem(int itemIdentifier) {

		boolean itemAlreadyAddedThisSale = sale.checkForExistingItem(itemIdentifier);

		if (itemAlreadyAddedThisSale){
			return sale.addExistingItem(itemIdentifier);
		}
		else {

		}
		return null;
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

	public Controller Controller() {
		return null;
	}

}
