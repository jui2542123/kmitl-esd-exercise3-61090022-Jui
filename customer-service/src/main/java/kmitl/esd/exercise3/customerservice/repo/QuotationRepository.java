package kmitl.esd.exercise3.customerservice.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kmitl.esd.exercise3.customerservice.model.Quotation;

/**
 * Persistence for quotations
 */
public interface QuotationRepository extends CrudRepository<Quotation, Long> {

    /**
     * Find quotes by time
     * @param creationDateTime
     * @return creation datetime quotes
     */
    @Query("select q from Quotation q where q.creationDateTime >= :creationDateTime")
    List<Quotation> findAllWithCreationDateTimeAfter(@Param("creationDateTime") LocalDateTime creationDateTime);

    /**
     * Find quotes by id
     * @param customerId
     * @return customer id quotes
     */
    List<Quotation> findAllByCustomerId(@Param("customerId") Long customerId);
}
