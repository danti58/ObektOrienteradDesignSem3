package se.kth.iv1350.view;


import se.kth.iv1350.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
	private double ammountEarned = 0;

	@Override
	public void newSale(double monyEarnd) {
		increseTotalEarn(monyEarnd);
		printAmmountEarned();
	}

	private void printAmmountEarned() {
		System.out.println("We have now a total ammount " + ammountEarned + " kr earned");
		
	}

	private void increseTotalEarn(double monyEarnd) {
		ammountEarned += monyEarnd;
	}
	
}
