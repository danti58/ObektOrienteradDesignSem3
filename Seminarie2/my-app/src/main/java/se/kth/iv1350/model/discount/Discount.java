package se.kth.iv1350.model.discount;

import se.kth.iv1350.dbHandler.CustomerRegistry;
import se.kth.iv1350.model.DTO.SaleDTO;

/**
 * Handles the discount logistics
 *
 */
public class Discount {

    CustomerRegistry customerRegistry;

    /**
     * Creates a instance that represents the discount.
     *
     * @param customerRegistry list of all the customers eligible for discount
     */
    public Discount(CustomerRegistry customerRegistry){
        this.customerRegistry = customerRegistry;
    }

    /**
     * Decides if a customer is eligible for discount
     *
     * @param saleInfo contains information about the Sale including customer identification
     * @return the setting for future handling of discount
     */
    public DiscountAvailability decideDiscount(SaleDTO saleInfo){

        boolean customerFound = customerRegistry.findCustomer(saleInfo.getCustomerIdentification());
        if(customerFound){
            return new HasDiscount();
        }
        return new DosentHaveDiscount();
    }
}
