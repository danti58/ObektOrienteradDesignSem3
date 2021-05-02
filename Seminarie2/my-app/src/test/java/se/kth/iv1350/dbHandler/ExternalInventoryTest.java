package se.kth.iv1350.dbHandler;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class ExternalInventoryTest {

    ExternalInventory externalInventoryToTest;

    @BeforeEach
    public void setup(){
        externalInventoryToTest = new ExternalInventory();
    }

    @AfterEach
    public void tearDown(){
        externalInventoryToTest = null;
    }

    @Test
    public void testGetExistingItem() {

    }
}