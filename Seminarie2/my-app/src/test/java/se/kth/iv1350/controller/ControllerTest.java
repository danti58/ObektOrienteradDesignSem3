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
	private Controller contrToTest;


	@BeforeEach
	void setUp() throws Exception {
		saleNotTesting = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		saleNotTesting = null;
		reciptDTONotTesting = null;
		itemListToComapre = null;
		contrToTest = null;
	}

	@Test
	void testPaymentTransaction() {
		int itemIdentifier = 300;
		
		contrToTest.startNewSale();
		contrToTest.addItem(itemIdentifier);

		contrToTest.paymentTransaction(300);
		
		
		
		
		
		
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
