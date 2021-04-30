package Seminarie3.model;

import Seminarie3.model.DTO.Java.util.ArayList;
import Seminarie3.model.DTO.Java.lang.String;
import Seminarie3.model.DTO.SaleDTO;
import Seminarie3.model.DTO.DisplayDTO;
import Seminarie3.model.DTO.RecieptDTO;

public class Sale {

	private Java.util.ArayList itemDTOList;

	private double runningTotal;

	private double priceAfterDiscount;

	private Java.lang.String storeName;

	private Java.lang.String storeAdress;

	private SaleDTO saleDTO;

	private DisplayDTO displayDTO;

	private RecieptDTO recieptDTO;

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
