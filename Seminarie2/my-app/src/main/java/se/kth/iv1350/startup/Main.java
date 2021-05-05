package se.kth.iv1350.startup;

import se.kth.iv1350.view.View;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.controller.Controller;

public class Main {

	

	public static void main(String[] args) throws Exception {
		ExternalInventory externalInventory = new ExternalInventory();
        ExternalAccounting externalAccounting = new ExternalAccounting();
        Controller contr = new Controller(externalInventory, externalAccounting);
        View view = new View(contr);

        view.hardcode();
		
		
	}
}
