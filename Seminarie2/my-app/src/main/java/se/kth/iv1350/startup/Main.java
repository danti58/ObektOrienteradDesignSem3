package se.kth.iv1350.startup;

import se.kth.iv1350.view.View;
import se.kth.iv1350.dbHandler.ExternalAccounting;
import se.kth.iv1350.dbHandler.ExternalInventory;
import se.kth.iv1350.controller.Controller;

public class Main {

	private View view;

	private ExternalAccounting externalAccounting;

	private ExternalInventory externalInventory;

	private Controller controller;
	
	
	public static void main(String[] args) {
		Controller contr = new Controller();
		View view = new View(contr);
		ExternalAccounting externalAccounting = new ExternalAccounting();
		ExternalInventory externalInventory = new ExternalInventory();
		
		view.hardcode();
		
		
	}
}
