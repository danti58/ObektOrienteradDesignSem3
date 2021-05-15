package se.kth.iv1350.controller;

import se.kth.iv1350.dbHandler.ExternalInventoryException;
import se.kth.iv1350.dbHandler.ItemNotFoundException;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SaleObserver;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;
import se.kth.iv1350.view.TotalRevenueView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	private Sale sale;
	private ExternalAccounting externalAccounting;
	private ExternalInventory externalInventory;
	private List<SaleObserver> saleObservers = new ArrayList<>();


	public Controller(ExternalInventory externalInventoryIn, ExternalAccounting externalAccountingIn) {
		externalInventory = externalInventoryIn;
		externalAccounting = externalAccountingIn;

	}

	/**
	 * Construct new Sale
	 * Sends a list of observers to Sale
	 */
	public void startNewSale() {
		sale = new Sale();
		sale.addSaleObservers(saleObservers);
	}

	/*
	*
	* Checks Sale if the item is already in Sale. If yes it updates the item quantity,
	* if not it gets the item from externalInventory and adds it to the sale. Returns the
	* values that needs to be displayed to the customer.
	*
	*/
	public DisplayDTO addItem(int itemIdentifier) throws ItemNotFoundException, OperationFailedException {


		boolean itemAlreadyAddedThisSale = sale.checkForExistingItem(itemIdentifier);
		DisplayDTO displayMessage = null;

		if (itemAlreadyAddedThisSale){
			displayMessage = sale.addExistingItem(itemIdentifier);
		}
		else {
			try {
				displayMessage = sale.addNewItem(externalInventory.getExistingItem(itemIdentifier));
			} catch (ExternalInventoryException extInvExc) {
				try {
					FileWriter writer = new FileWriter("C:\\Users\\Dante\\IdeaProjects\\ObjektOrienterad\\Sem3\\Seminarie2\\my-app\\Output\\ErrorMessages.txt");
					writer.write(extInvExc.getMessage());
					writer.close();
					throw new OperationFailedException("Could not connect to server");
				} catch (IOException IOe){
					System.out.println("FileWriter error");
				}
				//logStream = new PrintWriter(new FileWriter("errorInformation.txt"), true);
			}

		}
		return displayMessage;
	}

	/*
	 * gets the total price from sale, and gives it to the view so the cashier can tell the customer what the cost is
	 */
	public double endSale() {
		return sale.getTotalPrice();
	}

	/*
	 * 
	 * Gets all the important information from sale for the receipt and returns it to the viw as a DTO
	 * 
	 */
	public RecieptDTO paymentTransaction(double cash) throws Exception {
		
		
		RecieptDTO printReci = sale.createRecipt(cash);
		externalAccounting.updateAccounting(printReci);			
		externalInventory.updateInventory(printReci);
		
		sale = null;
		
		return printReci;
	}

	/**
	 * Adds new observer to saleObservers list
	 * @param obs the class that want to observe Sale
	 */
	public void addObserver(TotalRevenueView obs) {
		saleObservers.add(obs);
		
	}

}
