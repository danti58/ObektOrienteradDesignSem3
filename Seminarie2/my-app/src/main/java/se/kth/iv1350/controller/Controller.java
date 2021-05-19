package se.kth.iv1350.controller;

import se.kth.iv1350.dbHandler.ExternalInventoryException;
import se.kth.iv1350.dbHandler.ItemNotFoundException;
import se.kth.iv1350.model.DTO.SaleDTO;
import se.kth.iv1350.model.discount.Discount;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SaleObserver;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;
import se.kth.iv1350.model.discount.DiscountAvailability;
import se.kth.iv1350.view.TotalRevenueView;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the communicator between the view and other parts of the program.
 * It handles no logic and only sends out calls to the correct classes
 *
 */

public class Controller {

	private Sale sale;
	private Discount discount;
	private DiscountAvailability discountAvailability;
	private ExternalAccounting externalAccounting;
	private ExternalInventory externalInventory;
	private List<SaleObserver> saleObservers;


	/**
	 * Creates a new controller object
	 *
	 * @param externalInventoryIn reference to the external inventory
	 * @param externalAccountingIn reference to external accounting system
	 * @param discount reference to the discount class
	 */
	public Controller(ExternalInventory externalInventoryIn, ExternalAccounting externalAccountingIn, Discount discount) {
		externalInventory = externalInventoryIn;
		externalAccounting = externalAccountingIn;
		this.discount = discount;
		saleObservers = new ArrayList<>();
	}

	/**
	 * Construct new Sale
	 * Sends a list of observers to Sale
	 */
	public void startNewSale() {
		sale = new Sale();
		sale.addSaleObservers(saleObservers);
	}

	/**
	 * Checks Sale if the item is already in Sale. If yes it updates the item quantity,
	 * if not it gets the item from externalInventory and adds it to the sale.
	 *
	 * @param itemIdentifier identifier used for searching a item
	 * @return relevant item information and running total
	 * @throws ItemNotFoundException if the itemIdentifier does not correspond with any of the exiting Items
	 * @throws OperationFailedException if failed to connect to database
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
					FileWriter writer = new FileWriter("errorMessage.txt");
					writer.write(extInvExc.getMessage());
					writer.close();
					throw new OperationFailedException("Could not connect to server");
				} catch (IOException IOe){
					System.out.println("FileWriter error");
				}
			}

		}
		return displayMessage;
	}

	/**
	 * gets the total price from sale, and gives it to the view
	 * so the cashier can tell the customer what the cost is
	 */
	public double endSale() {
		return sale.endSale();
	}

	/**
	 * Gets all the important information from sale for the receipt and returns it to the view as a DTO
	 *
	 * @param cash the amount paid by the customer
	 * @return All the information of the sale in the form of a receipt
	 * @throws Exception of cash is less then running total
	 */
	public RecieptDTO paymentTransaction(double cash) throws Exception {
		
		
		RecieptDTO printReci = sale.createRecipt(cash);
		externalAccounting.updateAccounting(printReci);			
		externalInventory.updateInventory(printReci);
		
		sale = null;
		
		return printReci;
	}

	/**
	 * Gets information from sale and sends it to discount to calculate a new price.
	 *
	 * @param customerIdentification customers identification to check for discount
	 * @return the price calculated after discount has been applied
	 */

	public double priceAfterDiscount(int customerIdentification){

		double priceAfterDiscount;

		SaleDTO saleInformation = sale.getSaleDTO(customerIdentification);
		discountAvailability = discount.decideDiscount(saleInformation);

		priceAfterDiscount = discountAvailability.calculateDiscount(saleInformation.getRunningTotal());
		sale.updateTotalPrice(priceAfterDiscount);

		return priceAfterDiscount;
	}

	/**
	 * Adds new observer to saleObservers list
	 * @param obs the class that want to observe Sale
	 */
	public void addObserver(SaleObserver obs) {
		saleObservers.add(obs);
		
	}

}
