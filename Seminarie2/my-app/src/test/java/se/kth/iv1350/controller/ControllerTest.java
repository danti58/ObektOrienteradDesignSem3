package se.kth.iv1350.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.model.DTO.DisplayDTO;
import se.kth.iv1350.model.Sale;

public class ControllerTest {

    private Controller controllerToTest;

    @BeforeEach
    public void setup(){
        controllerToTest = new Controller();
    }

    @AfterEach
    public void tearDown(){
        controllerToTest = null;
    }


    @Test
    public void testAddItemNewItem() throws Exception {
        int itemIdentifierToAdd = 2;
        DisplayDTO correctDisplay = new DisplayDTO(32, 1.12, 60, "Prosciutto");

        DisplayDTO supposedCorrect = controllerToTest.addItem(itemIdentifierToAdd);
        
    }
}