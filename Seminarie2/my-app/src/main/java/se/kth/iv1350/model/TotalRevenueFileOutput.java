package se.kth.iv1350.model;


import java.io.FileWriter;
import java.io.IOException;

import se.kth.iv1350.model.SaleObserver;


/**
 * 
 * Class that observes sale and prints total amount earned to a file
 * 
 * 
 * 
 *
 */


public class TotalRevenueFileOutput implements SaleObserver {
	private double ammountEarned = 0;

	/**
	 * Increments amount earned and prints to file
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
	 * Prints the total income from this instance of the program to a file.
	 * @throws IOException in case of printing to file error.
	 *
	 */
	private void printAmmountEarned() {
		try {
			FileWriter incomeWriter = new FileWriter("totalReweniewIncome.txt");
			incomeWriter.write(String.valueOf(ammountEarned));
			incomeWriter.close();
		}catch(IOException IOe){
			System.out.println("FileWriter error");
		
		}
	
		
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
