package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.controller.OperationFailedException;
import se.kth.iv1350.dbHandler.ItemNotFoundException;

import java.util.Scanner;


/**
 * This is a placeholder for the real view. I contains a hardcoded execution with calls to all
 * system operations in the controller.
 * 
 */




public class View {

	private Controller contr;


	/**
	 * Creates a instance of the view representing the visual part of the program
	 *
	 * @param contr the controller used for communicating with the rest of the program
	 */
	public View (Controller contr) {
		this.contr = contr;
		contr.addObserver(new TotalRevenueView());
		
	
	}

	/**
	 * Hardcoded interaction with the visual representation of the program
	 *
	 */

	public void hardcode() {
		Scanner keyboard = new Scanner(System.in);
		int itemIdentifier;
		int i = 1;
		int j;
		System.out.println("Start new sale? 1 = yes 0 = shut down");
		j = keyboard.nextInt();
		while(j == 1) {
			i = 1;
			contr.startNewSale();
			while (i != 0) {
			System.out.println("what is the item identifier");
			
				itemIdentifier = keyboard.nextInt();
				try {
					System.out.println(contr.addItem(itemIdentifier));
				} catch (ItemNotFoundException iteNotFouExc) {
					System.out.println(iteNotFouExc.getMessage());
				} catch (OperationFailedException opeFaiExc){
					System.out.println(opeFaiExc.getMessage());
				}
			
				System.out.print("Add another item? 1 = yes 0 = no \n");
				i = keyboard.nextInt();
			
			}

			contr.endSale();

			System.out.println("Did the customer ask for discount? 1 = yes 0 = no ");
			i = keyboard.nextInt();
			if (i == 1){
				System.out.println("Enter ID: ");
				i = keyboard.nextInt();
				contr.priceAfterDiscount(i);
			}

			System.out.println("how much cash did customer give?");
			try {
				System.out.println(contr.paymentTransaction(keyboard.nextInt()));
			} catch (Exception re){
				System.out.println(re.getMessage());
			}

		
			System.out.println("Start new sale? 1 = yes 0 = shut down");
			j = keyboard.nextInt();
		}
		
	}

}