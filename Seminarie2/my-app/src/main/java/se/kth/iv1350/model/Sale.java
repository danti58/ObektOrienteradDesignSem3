package se.kth.iv1350.model;

import java.util.*;

import se.kth.iv1350.model.DTO.SaleDTO;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;

public class Sale {

	private ArrayList itemDTOList;

	private double runningTotal;

	private double priceAfterDiscount;

	private String storeName;

	private String storeAdress;

	private SaleDTO saleDTO;

	private DisplayDTO displayDTO;

	private RecieptDTO recieptDTO;

	public Sale Sale() {
		return null;
	}

	public boolean checkForExistingItem(int itemIdentifier) {
		return false;
	}

	public DisplayDTO updateItemQuantity(int itemQuantity) {
		return null;
	}

	public DisplayDTO addNewItem(Item currentItem, int itemQuantity) {
		return null;
	}

	public double getTotalPrice() {
		return 0;
	}

	public SaleDTO getSaleDTO(int customerIdentification) {
		return null;
	}

	public void updateTotalPrice(int priceAfterDiscount) {

	}

	public void calculateChange() {

	}

	private void calculateRunningTotal() {

	}

	public RecieptDTO createRecipt(int cash) {
		return null;
	}

	private void getTime() {

	}

}
