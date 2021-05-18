package se.kth.iv1350.model.discount;


/**
 * Implements the methods for handling the situation where the
 * customer does not have rights to discount
 */

public class DosentHaveDiscount implements DiscountAvailability{


    /**
     * Creates a instance for operations where discounts are not given
     *
     */
    public DosentHaveDiscount(){

    }

    /**
     * The customer is not eligible to discount so the running total is not changed.
     *
     * @param runningTotal total cost of purchase before discount
     * @return total cost of purchase after discount
     */
    @Override
    public double calculateDiscount(double runningTotal) {
        return runningTotal;

    }

}
