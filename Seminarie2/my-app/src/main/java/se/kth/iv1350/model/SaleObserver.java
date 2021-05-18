package se.kth.iv1350.model;

/**
 * The class observing sale
 *
 */
public interface SaleObserver {

	/**
	 * Invoked when a Sale is completed.
	 *
	 * @param monyEarnd income from latest sale
	 */
	void newSale(double monyEarnd);
}

