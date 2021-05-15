package se.kth.iv1350.view;


import se.kth.iv1350.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
	private double ammountEarned = 0;


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
