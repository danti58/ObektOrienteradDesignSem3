package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.model.DTO.DisplayDTO;

import java.util.ArrayList;

public class SaleTest {

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

        boolean isEqual = true;

        if(correctDisplay.getRunningTotal() != supposedCorrect.getRunningTotal()){
            isEqual = false;
        }
        if (correctDisplay.getItemVAT() != supposedCorrect.getItemVAT()){
            isEqual = false;
        }
        if (correctDisplay.getItemPrice() != supposedCorrect.getItemPrice()){
            isEqual = false;
        }
        if (!correctDisplay.getItemName().equals(correctDisplay.getItemName())){
            isEqual = false;
        }


        assertTrue(isEqual);

    }




}