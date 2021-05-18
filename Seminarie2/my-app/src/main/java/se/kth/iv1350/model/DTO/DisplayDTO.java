package se.kth.iv1350.model.DTO;

/**
 * A class used for representing the information to be displayed to the customer
 *
 */
public class DisplayDTO {

	private double runningTotal;
	private double itemVAT;
	private double itemPrice;
	private String itemName;


	/**
	 * Creates a new instance of a DisplayDTO
	 *
	 * @param runningTotalIn current total price of the sale
	 * @param itemVATIn vat of the item being added
	 * @param itemPriceIn price of the item being added
	 * @param itemNameIn name of the item being added
	 */
	public DisplayDTO (double runningTotalIn, double itemVATIn, double itemPriceIn, String itemNameIn) {

		runningTotal = runningTotalIn;
		itemVAT = itemVATIn;
		itemPrice = itemPriceIn;
		itemName = itemNameIn;
	}

	public double getRunningTotal() {
		return runningTotal;
	}

	public double getItemVAT() {
		return itemVAT;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	/**
	 * String representation of DisplayDTO
	 *
	 * @return a string representation of DisplayDTO
	 */
	public String toString(){

		return runningTotal + " " + itemVAT + " " + itemPrice + " " + itemName;
	}
}
