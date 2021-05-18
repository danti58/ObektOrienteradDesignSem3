package se.kth.iv1350.model.discount;


/**
 * Implements the methods for handling the situation where the
 * customer does have rights to discount
 */


public class HasDiscount implements DiscountAvailability{

    double discountValue = 0.9;

    /**
     * Creates a instance for operations where discounts are given
     *
     */
    public HasDiscount(){
    }


    /**
     * Calculates the discount
     *
     * @param runningTotal total cost of purchase before discount
     * @return total cost of purchase after discount
     */
    @Override
    public double calculateDiscount(double runningTotal) {

        return runningTotal * discountValue;
    }

}
