package se.kth.iv1350.model.DTO;

import java.util.*;

public class DisplayDTO {

	private double runningTotal;
	private double itemVAT;
	private double itemPrice;
	private String itemName;


	/*
	*
	* Creates a DisplayDTO
	*
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

	public String toString(){

		return runningTotal + " " + itemVAT + " " + itemPrice + " " + itemName;
	}
}
