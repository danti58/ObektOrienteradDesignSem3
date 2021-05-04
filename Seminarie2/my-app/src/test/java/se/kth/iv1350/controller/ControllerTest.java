package se.kth.iv1350.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.DTO.RecieptDTO;

class ControllerTest {
	private Sale saleNotTesting;
	private RecieptDTO reciptDTONotTesting;
	private ArrayList<Item> itemListToComapre; 



	@BeforeEach
	void setUp() throws Exception {
		saleNotTesting = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		saleNotTesting = null;
		reciptDTONotTesting = null;
		itemListToComapre = null;
	}

	@Test
	void testPaymentTransaction() {
		double ammountGivenToCashier = 300;
		double ammountRunningTotal = 2000;
		double change = ammountRunningTotal - ammountGivenToCashier;
		
        Item aItem = new Item("SearchedItem", 2, 25.2, 100.2);
        Item differentItem = new Item("differentItem", 4, 15, 56);
        Item anotherItem = new Item("anotherItem", 45, 5, 1004);
    	double totalVATPrice = differentItem.itemPrice * differentItem.itemVAT * 0.01 +  aItem.itemPrice * aItem.itemVAT * 0.01 + anotherItem.itemPrice * anotherItem.itemVAT * 0.01;
        saleNotTesting.addNewItem(differentItem);
        saleNotTesting.addNewItem(aItem);
        saleNotTesting.addNewItem(anotherItem);
		saleNotTesting.setRunningTotal(ammountRunningTotal);
		
		reciptDTONotTesting = saleNotTesting.createRecipt(ammountGivenToCashier);
		itemListToComapre = new ArrayList<>();
		itemListToComapre.add(differentItem);
		itemListToComapre.add(aItem);
		itemListToComapre.add(anotherItem);
		
		RecieptDTO expectedReciptDTO = new RecieptDTO("ThatFoodStore", "ThatStoreAdress 69", itemListToComapre, ammountRunningTotal,
				totalVATPrice, LocalDate.now(), LocalTime.now(), ammountGivenToCashier, change);

		
		assertEquals(expectedReciptDTO.getCash(), reciptDTONotTesting.getCash(), " cash is wrong");
		assertEquals(expectedReciptDTO.getChange(), reciptDTONotTesting.getChange(), " change is wrong");
		assertEquals(expectedReciptDTO.getDate(), reciptDTONotTesting.getDate(), " date is wrong");
		assertEquals(expectedReciptDTO.getTime(), reciptDTONotTesting.getTime(), " time is wrong");
		assertEquals(expectedReciptDTO.getItemList(), reciptDTONotTesting.getItemList(), " list is wrong");
		assertEquals(expectedReciptDTO.getStoreAdress(), reciptDTONotTesting.getStoreAdress(), " store adress is wrong");
		assertEquals(expectedReciptDTO.getStoreName(), reciptDTONotTesting.getStoreName(), " store name is wrong");
		assertEquals(expectedReciptDTO.getTotalPrice(), reciptDTONotTesting.getTotalPrice(), " total price is wrong");
		assertEquals(expectedReciptDTO.getTotalVATPrice(), reciptDTONotTesting.getTotalVATPrice(), " totalVATprice is wrong");

	}

}
