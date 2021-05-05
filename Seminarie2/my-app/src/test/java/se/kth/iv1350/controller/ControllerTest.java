package se.kth.iv1350.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.model.DTO.DisplayDTO;

public class ControllerTest {

    private Controller controllerToTest;
    private ExternalInventory extInventory;
    private ExternalAccounting extAccounting;

    @BeforeEach
    public void setup(){
        extInventory = new ExternalInventory();
        extAccounting = new ExternalAccounting();
        controllerToTest = new Controller(extInventory, extAccounting);
        controllerToTest.startNewSale();
    }

    @AfterEach
    public void tearDown(){
        extInventory = null;
        extAccounting = null;
        controllerToTest = null;
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

