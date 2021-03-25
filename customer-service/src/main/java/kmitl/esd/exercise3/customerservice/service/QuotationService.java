package kmitl.esd.exercise3.customerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import kmitl.esd.exercise3.customerservice.model.Quotation;
import kmitl.esd.exercise3.customerservice.repo.QuotationRepository;

/**
 * Quotation service, business logic for quotation data
 */
@Service
public class QuotationService {
    Logger logger = Logger.getLogger(QuotationService.class.toString());

    /**
     * Persistence for quotes
     */
    @Autowired
    QuotationRepository quotationRepository;

    /**
     * service for customer
     */
    @Autowired
    CustomerService customerService;

    /**
     * get all quotations
     *
     * @return quotations list
     */
    public List<Quotation> getAllQuotations() {
        List<Quotation> quotations = new ArrayList<>();
        quotationRepository.findAll().forEach(quotation -> quotations.add(quotation));
        return quotations;
    }

    /**
     * Get quotations
     *
     * @param customerId
     * @return quotations list customerid
     */
    public List<Quotation> getQuotationsByCustomerId(Long customerId) {
        return quotationRepository.findAllByCustomerId(customerId);
    }

    /**
     * Save or update
     *
     * @param quotation
     * @return void
     */
    public void saveOrUpdate(Quotation quotation) {
        if (quotation.getCustomer() == null || quotation.getCustomer().getId() == null) {
            throw new Error("Must have customer");
        }

        CustomerDTO customer = customerService.getCustomerById(quotation.getCustomer().getId());
        if (customer == null) {
            throw new Error("No customer");
        }

        logger.info("customer: " + customer.toString());

        quotationRepository.save(quotation);
    }

    /**
     * Delete quotation
     *
     * @param quotationId
     * @return void
     */
    public void delete(Long quotationId) {
        quotationRepository.deleteById(quotationId);
    }
}
