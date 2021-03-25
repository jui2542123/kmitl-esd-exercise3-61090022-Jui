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
     * get all customers
     *
     * @return list of customers
     */
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    /**
     * get customer name
     *
     * @param name of the customer
     * @return list of customers + name
     */
    public List<CustomerDTO> getCustomersByName(String name) {
        List<CustomerDTO> customers = new ArrayList<>();
        customerRepository.findByNameOrderByName(name).forEach(customer -> customers.add(customer));
        return customers;
    }

    /**
     * get customer
     *
     * @param id of the customer
     * @return customer with the id
     */
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    /**
     * create or update
     *
     * @return void
     */
    public void createOrUpdate(CustomerDTO customer) {
        customerRepository.save(customer);
    }

    /**
     * Function to delete customer
     *
     * @param customerid
     * @return void
     */
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
