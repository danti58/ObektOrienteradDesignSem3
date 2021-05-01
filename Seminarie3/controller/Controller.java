package Seminarie3.controller;

import Seminarie3.model.Sale;
import Seminarie3.model.Discount;
import Seminarie3.dbHandler.ExternalAccounting;
import Seminarie3.dbHandler.ExternalInventory;
import Seminarie3.model.DTO.DisplayDTO;
import Seminarie3.model.DTO.RecieptDTO;

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

	public RecieptDTO paymentTransaction(int cash) {
		return null;
	}

	public Controller Controller() {
		return null;
	}

}
