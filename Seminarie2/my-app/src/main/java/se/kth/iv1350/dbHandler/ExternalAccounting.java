package se.kth.iv1350.dbHandler;

import java.util.*;

import se.kth.iv1350.model.DTO.RecieptDTO;

/**
 * Holds information about the stores accounting
 * This class is a Singleton class
 */

public class ExternalAccounting {

	private static final ExternalAccounting singletonAccounting = new ExternalAccounting();
	private ArrayList pastPurchaseList;

	public static ExternalAccounting getExternalAccounting(){
		return singletonAccounting;
	}

	/**
	 * Placeholder for updating the database after a purchase is completed.
	 *
	 * @param printReci all the information from the sale needed to update the accounting
	 */
	public void updateAccounting(RecieptDTO printReci) {
		
	}

}
