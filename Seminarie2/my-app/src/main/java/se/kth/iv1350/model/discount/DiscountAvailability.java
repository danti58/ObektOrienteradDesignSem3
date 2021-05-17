package se.kth.iv1350.model.discount;

import se.kth.iv1350.dbHandler.CustomerRegistry;
import se.kth.iv1350.model.DTO.CustomerDTO;
import se.kth.iv1350.model.DTO.SaleDTO;

public interface DiscountAvailability {

    //CustomerRegistry customerRegistry;

    double calculateDiscount(SaleDTO saleInfo);

    /*public Discount(CustomerRegistry customerRegistry){
        this.customerRegistry = customerRegistry;
    }

    public double calculateDiscount(SaleDTO saleInfo) {

        CustomerDTO currentCustomer = customerRegistry.findCustomer(saleInfo.getCustomerIdentification());
        double newPrice;
        if (currentCustomer == null){
            newPrice = saleInfo.getRunningTotal();
        }
        else {
            newPrice = currentCustomer.getAmountOfDiscount() * saleInfo.getRunningTotal();
        }

        return newPrice;
    }*/

}

