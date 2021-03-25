
package kmitl.esd.exercise3.server.web;

import java.util.List;

import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import kmitl.esd.exercise3.customerservice.service.CustomerService;

/**
 * API for customers (RestController)
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     *get all of the customers
     *
     * @return list of customers
     */
    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     *get customer by id
     *
     * @param id of the customer
     * @return list of customers
     */
    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    /**
     *save customer
     *
     * @param customer
     */
    @PostMapping("/customer")
    public void saveCustomer(@RequestBody CustomerDTO customer) {
        customerService.createOrUpdate(customer);
    }

    /**
     * delete customer
     *
     * @param id of the customer
     */
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }
}