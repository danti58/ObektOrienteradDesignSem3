  
package se.kth.iv1350.model;

/**
 * Represents the item in the store and in the external inventory
 *
 */
public class Item {

	public String itemName;
	public int itemIdentifier;
	public double itemVAT;
	public double itemPrice;
	public int quantity;

	/**
	 * Creates a new instance of an item from the store
	 * and setting quantity to 0
	 *
	 * @param itemNameIn the name of the item
	 * @param itemIdentifierIn the identifier used for searching the item
	 * @param itemVATIn the items vat in decimal
	 * @param itemPriceIn the items price
	 */
	public Item (String itemNameIn, int itemIdentifierIn, double itemVATIn, double itemPriceIn) {

		itemName = itemNameIn;
		itemIdentifier = itemIdentifierIn;
		itemVAT = itemVATIn;
		itemPrice = itemPriceIn;
		quantity = 0;

	}

	/**
	 * Creates a new instance of an item from the store
	 *
	 * @param itemNameIn the name of the item
	 * @param itemIdentifierIn the identifier used for searching the item
	 * @param itemVATIn the items vat in decimal
	 * @param itemPriceIn the items price
	 * @param quantityIn the quantity of the item
	 */
	public Item (String itemNameIn, int itemIdentifierIn, double itemVATIn, double itemPriceIn, int quantityIn) {

		itemName = itemNameIn;
		itemIdentifier = itemIdentifierIn;
		itemVAT = itemVATIn;
		itemPrice = itemPriceIn;
		quantity = quantityIn;
	}

	/**
	 * String representation of the item
	 *
	 * @return a string representation of the item
	 */

	public String toString() {
		
		return itemName + " item price " +  String.format("%.2f",itemPrice) + "   ammount "+ quantity + "\n";
	}
	
	
	
}