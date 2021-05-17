package se.kth.iv1350.dbHandler;

import se.kth.iv1350.model.DTO.CustomerDTO;

import java.util.ArrayList;

public class CustomerRegistry {

    private ArrayList<CustomerDTO> customerList;

    public CustomerRegistry(){
        CustomerDTO lad = new CustomerDTO("Lad", 0);
        CustomerDTO chad = new CustomerDTO("Chad", 1);
        CustomerDTO lilly = new CustomerDTO("Lilly", 2);
        CustomerDTO jace = new CustomerDTO("Jace", 3);
    }

    public CustomerDTO findCustomer(int customerIdentification){

        for (CustomerDTO currentCustomer: customerList){
            if (currentCustomer.getCustomerIdentification() == customerIdentification){
                return currentCustomer;
            }
        }
        return null;
    }
}
