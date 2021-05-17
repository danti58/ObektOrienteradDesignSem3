package se.kth.iv1350.model.discount;

import se.kth.iv1350.dbHandler.CustomerRegistry;
import se.kth.iv1350.model.DTO.CustomerDTO;
import se.kth.iv1350.model.DTO.SaleDTO;

public class HasDiscount implements DiscountAvailability{

    CustomerRegistry customerRegistry;
    double discountValue = 0.9;

    public HasDiscount(CustomerRegistry customerRegistry){
        this.customerRegistry = customerRegistry;
    }

    @Override
    public double calculateDiscount(SaleDTO saleInfo) {

        return saleInfo.getRunningTotal() * discountValue;
    }
}
