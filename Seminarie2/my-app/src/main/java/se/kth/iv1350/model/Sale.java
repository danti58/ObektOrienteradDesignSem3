package se.kth.iv1350.model;

import java.util.*;

import se.kth.iv1350.model.DTO.SaleDTO;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;
import java.time.LocalTime;
import java.time.LocalDate;

public class Sale {
		
	private ArrayList itemDTOList;
	private double runningTotal;
	private double priceAfterDiscount;
	private String storeName = "ThatFoodStore";
	private String storeAdress = "ThatStoreAdress 69";
	private SaleDTO saleDTO;
	private DisplayDTO displayDTO;
	private RecieptDTO recieptDTO;
	private double change;
	
	
		
	public RecieptDTO createRecipt(int cash) {
		
		calculateChange(cash);
		

		RecieptDTO printReci = new RecieptDTO(storeName, storeAdress, itemList, totalPrice, discount,
				priceVAT, LocalDate.now(), LocalTime.now(), cash, change, priceAfterDiscount);

		return null;
	}
	
	
	
	public Sale Sale() {
		return null;
	}

	public boolean checkForExistingItem(int itemIdentifier) {
		return false;
	}

	public DisplayDTO updateItemQuantity(int itemQuantity, int itemIdentifier) {
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


	private void calculateRunningTotal() {

	}

	public void calculateChange(double cash) {
		change = priceAfterDiscount - cash;
	}



}
