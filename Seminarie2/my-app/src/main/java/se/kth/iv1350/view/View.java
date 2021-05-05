package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import java.util.Scanner;


/*
 * This is a placeholder for the real viw. I contains a hardcoded execution with calls to all
 * system operations in the controller.
 * 
 */



public class View {

	private Controller contr;



	public View (Controller contr) {
		this.contr = contr;
	
	}
	
	
	public void hardcode() {
		Scanner keyboard = new Scanner(System.in);
		int itemIdentifier;
		int i = 1;
		int j;
		System.out.println("Start new sale? 1 = yes 0 = shut down");
		j = keyboard.nextInt();
		while(j == 1) {
		contr.startNewSale();
		while (i != 0) {
			System.out.println("what is the item identifier");
			
			itemIdentifier = keyboard.nextInt();
			contr.addItem(itemIdentifier);
			
			System.out.print("Add another item? 1 = yes 0 = no");
			i = keyboard.nextInt();
			
		}
		
		contr.endSale();
		contr.paymentTransaction(10000);
		
		System.out.println("Start new sale? 1 = yes 0 = shut down");
		j = keyboard.nextInt();
		}
		
	}

}
