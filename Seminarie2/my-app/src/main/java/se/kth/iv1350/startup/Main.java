package se.kth.iv1350.startup;

import se.kth.iv1350.dbHandler.CustomerRegistry;
import se.kth.iv1350.model.discount.Discount;
import se.kth.iv1350.view.View;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.controller.Controller;

public class Main {

	

	public static void main(String[] args) throws Exception {
        CustomerRegistry customerRegistry = new CustomerRegistry();
        Discount discount = new Discount(customerRegistry);
        Controller contr = new Controller(ExternalInventory.getExternalInventory(), ExternalAccounting.getExternalAccounting(), discount);
        View view = new View(contr);

        view.hardcode();
		
		
	}
}
