package se.kth.iv1350.model.DTO;

import java.util.*;

public class DisplayDTO {

	private double runningTotal;
	private double itemVAT;
	private double itemPrice;
	private String itemName;

	public DisplayDTO (double runningTotalIn, double itemVATIn, double itemPriceIn, String itemNameIn) {

		runningTotal = runningTotalIn;
		itemVAT = itemVATIn;
		itemPrice = itemPriceIn;
		itemName = itemNameIn;
	}

}
