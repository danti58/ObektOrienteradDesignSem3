package Seminarie3.model.DTO;

import java.time.LocalTime;
import java.time.LocalDate;

public class RecieptDTO {

	private Java.lang.String storeName;

	private Java.lang.String storeAdress;

	private Java.util.ArayList itemList;

	private double totalPrice;

	private double discount;

	private double priceVAT;

	private int date;

	private int time;

	private double cash;

	private double change;
	
	private double priceAfterDiscount;

	RecieptDTO RecieptDTO(String storeName, String storeAdress, 
			Java.util.ArayList itemList, double totalPrice, double discount, 
			double priceVAT, LocalDate date, LocalTime time, double cash, double change) {
		return null;
	}

}
