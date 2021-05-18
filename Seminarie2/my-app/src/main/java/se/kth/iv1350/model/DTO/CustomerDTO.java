package se.kth.iv1350.model.DTO;

/**
 * The class representing a customer eligible for discount
 *
 */
public class CustomerDTO {

    private String name;
    private int customerIdentification;

    /**
     * Creates a new instance of a customer
     *
     * @param name the name of the customer
     * @param customerIdentification the customers identification
     */
    public CustomerDTO(String name, int customerIdentification){

        this.name = name;
        this.customerIdentification = customerIdentification;
    }

    public int getCustomerIdentification(){
        return this.customerIdentification;
    }

}
