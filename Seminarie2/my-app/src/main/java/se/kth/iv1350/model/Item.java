package se.kth.iv1350.model;

import java.util.*;

public class Item {

	public String itemName;
	public int itemIdentifier;
	public double itemVAT;
	public double itemPrice;
	public int quantity;

	public Item (String itemNameIn, int itemIdentifierIn, double itemVATIn, double itemPriceIn) {

		itemName = itemNameIn;
		itemIdentifier = itemIdentifierIn;
		itemVAT = itemVATIn;
		itemPrice = itemPriceIn;
		quantity = 1;
	}

	public Item (String itemNameIn, int itemIdentifierIn, double itemVATIn, double itemPriceIn, int quantityIn) {

		itemName = itemNameIn;
		itemIdentifier = itemIdentifierIn;
		itemVAT = itemVATIn;
		itemPrice = itemPriceIn;
		quantity = quantityIn;
	}

}
