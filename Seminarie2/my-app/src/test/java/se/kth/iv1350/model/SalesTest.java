package se.kth.iv1350.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import se.kth.iv1350.model.DTO.RecieptDTO;




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.model.DTO.DisplayDTO;

import java.util.ArrayList;

public class SalesTest {

	private RecieptDTO reciptDTONotTesting;
	private ArrayList<Item> itemListToComapre;

    private Sale saleToTest;


    @BeforeEach
    public void setup(){
        saleToTest = new Sale();
    }

    @AfterEach
    public void tearDown(){
        saleToTest = null;
    }
    
	 @Test
	 
	void testCreateRecipt() throws Exception {
		double ammountGivenToCashier = 2000;
		double ammountRunningTotal = 300;
		double change =  ammountGivenToCashier - ammountRunningTotal;
		
       Item aItem = new Item("SearchedItem", 2, 25.2, 100);
       Item differentItem = new Item("differentItem", 4, 15, 56);
       Item anotherItem = new Item("anotherItem", 45, 5, 1004);
       double totalVATPrice = aItem.itemPrice - (aItem.itemPrice / aItem.itemVAT) + differentItem.itemPrice - (differentItem.itemPrice / differentItem.itemVAT)  + anotherItem.itemPrice - (anotherItem.itemPrice / anotherItem.itemVAT);
       saleToTest.addNewItem(differentItem);
       saleToTest.addNewItem(aItem);
       saleToTest.addNewItem(anotherItem);
       saleToTest.setRunningTotal(ammountRunningTotal);
		
		reciptDTONotTesting = saleToTest.createRecipt(ammountGivenToCashier);
		itemListToComapre = new ArrayList<>();
		itemListToComapre.add(differentItem);
		itemListToComapre.add(aItem);
		itemListToComapre.add(anotherItem);
		
		RecieptDTO expectedReciptDTO = new RecieptDTO("ThatFoodStore", "ThatStoreAdress 69", itemListToComapre, ammountRunningTotal,
				totalVATPrice, LocalDate.now(), LocalTime.now(), ammountGivenToCashier, change);

		
		assertEquals(expectedReciptDTO.getCash(), reciptDTONotTesting.getCash(), " cash is wrong");
		assertEquals(expectedReciptDTO.getChange(), reciptDTONotTesting.getChange(), " change is wrong");
		assertEquals(expectedReciptDTO.getDate(), reciptDTONotTesting.getDate(), " date is wrong");
		//assertEquals(expectedReciptDTO.getTime(), reciptDTONotTesting.getTime(), " time is wrong");
		assertEquals(expectedReciptDTO.getItemList(), reciptDTONotTesting.getItemList(), " list is wrong");
		assertEquals(expectedReciptDTO.getStoreAdress(), reciptDTONotTesting.getStoreAdress(), " store adress is wrong");
		assertEquals(expectedReciptDTO.getStoreName(), reciptDTONotTesting.getStoreName(), " store name is wrong");
		assertEquals(expectedReciptDTO.getTotalPrice(), reciptDTONotTesting.getTotalPrice(), " total price is wrong");
		assertEquals(expectedReciptDTO.getTotalVATPrice(), reciptDTONotTesting.getTotalVATPrice(), " totalVATprice is wrong");
		
	}

	@Test
    public void testCreateReceiptNotEnoughCash() {
        double cash = 1;
        Item aItem = new Item("SearchedItem", 2, 25.2, 100);
        saleToTest.addNewItem(aItem);

        try {
            saleToTest.createRecipt(cash);
            fail("Transaction went through");
        } catch (Exception re){
            assertTrue(re.getMessage().contains(Double.toString(cash)), "Message did not contain cash");
        }

    }

    
    @Test
    public void testCheckForExistingItemNoItemFound() {
        Item aItem = new Item("SearchedItem", 2, 25, 100);
        Item differentItem = new Item("differentItem", 4, 15, 56);
        Item anotherItem = new Item("anotherItem", 45, 5, 1004);
        saleToTest.addNewItem(differentItem);
        saleToTest.addNewItem(aItem);
        saleToTest.addNewItem(anotherItem);

        assertFalse(saleToTest.checkForExistingItem(34));

    }

    @Test
    public void testCheckForExistingItemFound(){
        Item itemSearched = new Item("SearchedItem", 2, 25, 100);
        Item differentItem = new Item("differentItem", 4, 15, 56);
        Item anotherItem = new Item("anotherItem", 45, 5, 1004);
        saleToTest.addNewItem(differentItem);
        saleToTest.addNewItem(itemSearched);
        saleToTest.addNewItem(anotherItem);

        assertTrue(saleToTest.checkForExistingItem(2));
    }

    @Test
    public void testAddNewItem(){
        DisplayDTO correctDisplay = new DisplayDTO(32, 1.25, 32, "New item");

        Item newItem = new Item("New item", 4, 1.25, 32);

        DisplayDTO supposedCorrect = saleToTest.addNewItem(newItem);


        assertTrue(saleToTest.checkForExistingItem(4));
        assertEquals(correctDisplay.getRunningTotal(), supposedCorrect.getRunningTotal());
        assertEquals(correctDisplay.getItemVAT(), supposedCorrect.getItemVAT());
        assertEquals(correctDisplay.getItemPrice(), supposedCorrect.getItemPrice());
        assertEquals(correctDisplay.getItemName(), supposedCorrect.getItemName());
    }

    @Test
    public void testAddExistingItem(){
        DisplayDTO correctDisplay = new DisplayDTO(64, 1.25, 32, "New item");
        int identifierToUpdate = 3;
        int correctQuantity = 2;
        Item newItem = new Item("New item", identifierToUpdate, 1.25, 32);
        System.out.println(newItem.quantity);
        saleToTest.addNewItem(newItem);
        DisplayDTO supposedCorrect = saleToTest.addExistingItem(identifierToUpdate);

        System.out.println(newItem.quantity);
        assertEquals(newItem.quantity, correctQuantity);
        assertEquals(correctDisplay.getRunningTotal(), supposedCorrect.getRunningTotal());
        assertEquals(correctDisplay.getItemVAT(), supposedCorrect.getItemVAT());
        assertEquals(correctDisplay.getItemPrice(), supposedCorrect.getItemPrice());
        assertEquals(correctDisplay.getItemName(), supposedCorrect.getItemName());
    }




}

