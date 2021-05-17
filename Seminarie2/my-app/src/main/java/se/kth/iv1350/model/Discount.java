package se.kth.iv1350.model;

import se.kth.iv1350.dbHandler.CustomerRegistry;
import se.kth.iv1350.model.DTO.CustomerDTO;
import se.kth.iv1350.model.DTO.SaleDTO;

public class Discount {

    private CustomerRegistry customerRegistry;

    public Discount(CustomerRegistry customerRegistry){
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
    }

}