package se.kth.iv1350.view;


import se.kth.iv1350.model.SaleObserver;

	/**
	 * Class that observes the sale and prints to view
	 * 
	 *
	 */

public class TotalRevenueView implements SaleObserver {
	private double ammountEarned = 0;


	/**
	 * Increments the total amount earned and prints the new amount to screen.
	 * 
	 * 
	 */
	@Override
	public void newSale(double monyEarnd) {
		increseTotalEarn(monyEarnd);
		printAmmountEarned();
	}

	/**
	 *
	 * Displays the total income from this instance of the program.
	 *
	 */
	private void printAmmountEarned() {
		System.out.println("We have now a total ammount " + ammountEarned + " kr earned");
		
	}

	/**
	 * Updates the total income with values from the latest completed Sale.
	 *
	 * @param monyEarnd amount paid.
	 */

	private void increseTotalEarn(double monyEarnd) {
		ammountEarned += monyEarnd;
	}

}
