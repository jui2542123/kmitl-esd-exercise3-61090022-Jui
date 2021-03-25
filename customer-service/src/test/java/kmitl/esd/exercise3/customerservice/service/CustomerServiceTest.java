package kmitl.esd.exercise3.customerservice.service;

import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for CustomerService testing
 */

class CustomerServiceTest {
    private CustomerService customerService = new CustomerService();

    /**
     * method for getting all customers's testing
     */
    @Test
    void getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        assertEquals(allCustomers.size(),1);
    }

    /**
     * method for creating customer's testing
     */
    @Test
    void createCustomer() {
        customerService.createCustomer(new CustomerDTO(3L,"Dech",20L));
        assertEquals(customerService.getAllCustomers().size(),2);
        customerService.deleteCustomer(3L);
    }

    /**
     * method for updating customer's testing
     */
    @Test
    void updateCustomer() {
        CustomerDTO newCustomer = customerService.createCustomer(new CustomerDTO(3L,"Dech",20L));
        newCustomer.setName("Dech");

        CustomerDTO updateCustomer = customerService.updateCustomer(newCustomer);
        assertEquals(updateCustomer.getName(),"Dech2");
        customerService.deleteCustomer(3L);
    }

    /**
     * method for deleting customer's testing
     */
    @Test
    void deleteCustomer() {
        assertEquals(customerService.getAllCustomers().size(),1);
        customerService.deleteCustomer(1L);
        assertEquals(customerService.getAllCustomers().size(),0);
        customerService.createCustomer(new CustomerDTO(1L,"Dech3", 21L));
    }
}