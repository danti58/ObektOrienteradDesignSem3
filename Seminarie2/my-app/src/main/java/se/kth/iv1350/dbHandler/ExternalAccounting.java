package se.kth.iv1350.dbHandler;

import java.util.*;

import se.kth.iv1350.model.DTO.RecieptDTO;

public class ExternalAccounting {

	private static final ExternalAccounting singletonAccounting = new ExternalAccounting();
	private ArrayList pastPurchaseList;

	public static ExternalAccounting getExternalAccounting(){
		return singletonAccounting;
	}

	public void updateAccounting(RecieptDTO printReci) {
		
	}

}
