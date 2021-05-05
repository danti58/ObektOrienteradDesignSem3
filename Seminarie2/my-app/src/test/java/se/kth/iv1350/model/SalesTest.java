package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalesTest {

	private Sale saleToTest;
	
	@BeforeEach
	public void setUp(){
	saleToTest = new Sale();
	}

	@AfterEach
	void tearDown(){
		saleToTest = null;
	}


	/* dont need to test internal
	 @Test
	 
	void TestcalCalculateChange() {
		
		int cashGivenToChasier = 300;
		int runningTotalToSet = 180;
		saleToTest.setRunningTotal(runningTotalToSet);
		saleToTest.calculateChange(cashGivenToChasier);
		double result = saleToTest.getChange();
		double expResult = 120;
		assertEquals(expResult, result, "Amount of change is not correct");
		
	}
*/
}
