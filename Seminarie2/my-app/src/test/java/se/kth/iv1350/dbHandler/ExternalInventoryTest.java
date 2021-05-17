package se.kth.iv1350.dbHandler;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.model.Item;

public class ExternalInventoryTest {

    ExternalInventory externalInventoryToTest;

    @BeforeEach
    public void setup(){
        externalInventoryToTest = ExternalInventory.getExternalInventory();
    }

    @AfterEach
    public void tearDown(){
        externalInventoryToTest = null;
    }

    @Test
    public void testGetExistingItemSuccess() throws ItemNotFoundException, ExternalInventoryException {
        int itemIDToFind = 3;

        Item foundItem = externalInventoryToTest.getExistingItem(itemIDToFind);

        assertTrue(foundItem.itemName == "Meatballs");


    }

    @Test
    public void testGetExistingItemFailed() throws ExternalInventoryException{
        int itemIDToFind = 34;
        try {
            externalInventoryToTest.getExistingItem(itemIDToFind);
            fail("The item was returned");
        } catch (ItemNotFoundException re) {
            assertTrue(re.getMessage().contains(Integer.toString(itemIDToFind)),
                    "Exception message did not contain itemId");
        }

    }

    @Test
    public void testGetExistingItemFailedDatabase() throws ItemNotFoundException{
        int itemIDToFind = 999;
        String expectedResult = "Database very useful information";

        try {
            externalInventoryToTest.getExistingItem(itemIDToFind);
            fail("Database connection error did not throw exception");
        } catch (ExternalInventoryException re){
            assertEquals(expectedResult, re.getMessage());

        }
    }

    /*@Test
    public void testGetExistingItemQuantityZero(){

        int itemIDToFind = 76;
        int expectedQuantity = 0;
        try {
            externalInventoryToTest.getExistingItem(itemIDToFind);
            fail("The item was returned");
        } catch (Exception re) {
            assertTrue(re.getMessage().contains(Integer.toString(expectedQuantity)),
                    "Exception message did not contain quantity");
        }
    }*/
}