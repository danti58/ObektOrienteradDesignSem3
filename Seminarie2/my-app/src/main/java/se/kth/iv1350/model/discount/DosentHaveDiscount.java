package se.kth.iv1350.model.discount;

import se.kth.iv1350.dbHandler.CustomerRegistry;
import se.kth.iv1350.model.DTO.CustomerDTO;
import se.kth.iv1350.model.DTO.SaleDTO;

public class DosentHaveDiscount implements DiscountAvailability{

    CustomerRegistry customerRegistry;

    public DosentHaveDiscount(CustomerRegistry customerRegistry){
        this.customerRegistry = customerRegistry;
    }

    @Override
    public double calculateDiscount(SaleDTO saleInfo) {
        return saleInfo.getRunningTotal();

    }
}
