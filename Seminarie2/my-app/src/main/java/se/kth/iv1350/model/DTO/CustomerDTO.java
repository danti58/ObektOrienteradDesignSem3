package se.kth.iv1350.model.DTO;

public class CustomerDTO {

    private String name;
    private int customerIdentification;
    private double amountOfDiscount;

    public CustomerDTO(String name, int customerIdentification){

        this.name = name;
        this.customerIdentification = customerIdentification;
        this.amountOfDiscount = amountOfDiscount;
    }

    public int getCustomerIdentification(){
        return this.customerIdentification;
    }

}
