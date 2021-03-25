package kmitl.esd.exercise3.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kmitl.esd.exercise3.customerservice.repo.CustomerRepository;
import kmitl.esd.exercise3.customerservice.model.CustomerDTO;

/**
 * Customer service, business logic for customer data
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Function to get all of the customers
     *
     * @return list of customers
     */
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    /**
     * Function to get customers with a specified name
     *
     * @param name of the customer
     * @return list of customers with then name
     */
    public List<CustomerDTO> getCustomersByName(String name) {
        List<CustomerDTO> customers = new ArrayList<>();
        customerRepository.findByNameOrderByName(name).forEach(customer -> customers.add(customer));
        return customers;
    }

    /**
     * Function to get customer by id
     *
     * @param id of the customer
     * @return customer with the id
     */
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    /**
     * Function to create or update customer
     *
     * @return void
     */
    public void createOrUpdate(CustomerDTO customer) {
        customerRepository.save(customer);
    }

    /**
     * Function to delete customer
     *
     * @param id of the customer
     * @return void
     */
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
