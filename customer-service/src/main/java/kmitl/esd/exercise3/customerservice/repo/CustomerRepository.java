package kmitl.esd.exercise3.customerservice.repo;
import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Persistence for customers
 */
public interface CustomerRepository extends CrudRepository<CustomerDTO, Long>{

    /**
     * Find customers by name and ordered by name
     * @param name of customers to find
     * @return customers with the name or empty list
     */
    List<CustomerDTO> findByNameOrderByName(String name);
;
}
