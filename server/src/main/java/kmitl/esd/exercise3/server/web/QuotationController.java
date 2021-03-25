package kmitl.esd.exercise3.server.web;

import kmitl.esd.exercise3.customerservice.model.Quotation;
import kmitl.esd.exercise3.customerservice.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API for quotations (RestController)
 */
@RestController
public class QuotationController {

    @Autowired
    QuotationService quotationService;

    /**
     *get all of the quotations
     *
     * @return list of quotations
     */
    @GetMapping("/quotation")
    public List<Quotation> getAllQuotations() {
        return quotationService.getAllQuotations();
    }

    /**
     *get quotation by customer id
     *
     * @param id of the quotation
     * @return list of quotations
     */
    @GetMapping("/quotation/{id}")
    public List<Quotation> getQuotationsByCustomerId(@PathVariable("id") Long id) {
        return quotationService.getQuotationsByCustomerId(id);
    }

    /**
     *save quotation
     *
     * @param quotation
     */
    @PostMapping("/quotation")
    public void saveQuotation(@RequestBody Quotation quotation) {
        quotationService.saveOrUpdate(quotation);
    }

    /**
     *delete quotation
     *
     * @param id of the quotation
     */
    @DeleteMapping("/quotation/{id}")
    public void deleteQuotation(@PathVariable("id") Long id) {
        quotationService.delete(id);
    }
}
