package se.kth.iv1350.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;


import se.kth.iv1350.dbHandler.CustomerRegistry;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.model.discount.Discount;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.DTO.RecieptDTO;

public class ControllerTest {

    private Controller controllerToTest;

    private RecieptDTO reciptDTONotTesting;
	private ArrayList<Item> itemListToComapre;
	private ExternalInventory extInventory;
    private ExternalAccounting extAccounting;
    private Sale sale;
    private Discount discount;
    private CustomerRegistry customerRegistry;
	
    @BeforeEach
    public void setup(){
    	extInventory = ExternalInventory.getExternalInventory();
        extAccounting = ExternalAccounting.getExternalAccounting();
        customerRegistry = new CustomerRegistry();
        discount = new Discount(customerRegistry);
        controllerToTest = new Controller(extInventory, extAccounting, discount);
        controllerToTest.startNewSale();

    }

    @AfterEach
    public void tearDown(){
        extInventory = null;
        extAccounting = null;
        controllerToTest = null;
        reciptDTONotTesting = null;
    	itemListToComapre = null;
    }


	@Test
	void testPaymentTransaction() throws Exception  {
		int itemIdentifier = 2;
		double ammountGivenToCashier = 300;
	
		
	
		controllerToTest.addItem(itemIdentifier);
		
		reciptDTONotTesting = controllerToTest.paymentTransaction(ammountGivenToCashier);
		
		
		
		
		double expectedCash = 300;
		double expectedChange = 240;
		LocalDate expectedDate = LocalDate.now();
		LocalTime expectedTime = LocalTime.now();
		String expectedStoreAdress = "ThatStoreAdress 69";
		String expectedStoreName = "ThatFoodStore";
		double expectedTotalPrice = 60;
		double itemVAT = 1.12;
		double expectedTotalVATPrice = expectedTotalPrice - (expectedTotalPrice / itemVAT);
		
		System.out.println(reciptDTONotTesting);
		assertEquals(expectedCash, reciptDTONotTesting.getCash(), " cash is wrong");
		assertEquals(expectedChange, reciptDTONotTesting.getChange(), " change is wrong");
		assertEquals(expectedDate, reciptDTONotTesting.getDate(), " date is wrong");
		//assertEquals(expectedTime, reciptDTONotTesting.getTime(), " time is wrong");
		assertEquals(expectedStoreAdress, reciptDTONotTesting.getStoreAdress(), " store adress is wrong");
		assertEquals(expectedStoreName, reciptDTONotTesting.getStoreName(), " store name is wrong");
		assertEquals(expectedTotalPrice, reciptDTONotTesting.getTotalPrice(), " total price is wrong");
		assertEquals(expectedTotalVATPrice, reciptDTONotTesting.getTotalVATPrice(), " totalVATprice is wrong");
		
		
		
		
	}




    
    
    
    @Test
    public void testAddItemNewItem() throws Exception {
        int itemIdentifierToAdd = 2;
        DisplayDTO correctDisplay = new DisplayDTO(60, 1.12, 60, "Prosciutto");

        DisplayDTO supposedCorrect = controllerToTest.addItem(itemIdentifierToAdd);

        assertEquals(correctDisplay.getRunningTotal(), supposedCorrect.getRunningTotal());
        assertEquals(correctDisplay.getItemVAT(), supposedCorrect.getItemVAT());
        assertEquals(correctDisplay.getItemPrice(), supposedCorrect.getItemPrice());
        assertEquals(correctDisplay.getItemName(), supposedCorrect.getItemName());

    }

    @Test
    public void testAddItemExistingItem() throws Exception {
        int itemIdentifierToAdd = 6;
        int secondItem = 2;
        int correctRunningTotal = 98;
        DisplayDTO correctDisplay = new DisplayDTO(correctRunningTotal, 1.12, 19, "Salt and Vinegar chips");

        controllerToTest.addItem(itemIdentifierToAdd);
        controllerToTest.addItem(secondItem);
        DisplayDTO supposedCorrect = controllerToTest.addItem(itemIdentifierToAdd);

        System.out.println(supposedCorrect);

        assertEquals(correctDisplay.getRunningTotal(), supposedCorrect.getRunningTotal());
        assertEquals(correctDisplay.getItemVAT(), supposedCorrect.getItemVAT());
        assertEquals(correctDisplay.getItemPrice(), supposedCorrect.getItemPrice());
        assertEquals(correctDisplay.getItemName(), supposedCorrect.getItemName());

    }
}

