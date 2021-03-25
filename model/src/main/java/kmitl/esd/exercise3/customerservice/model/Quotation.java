package kmitl.esd.exercise3.customerservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Quotation model
 */
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Quotation {
    /**
     * quotation's id
     */
    @Id
    @Column
    private Long id;

    /**
     * quotation name
     */
    @Column() @NotNull @Size(min = 3, max = 240)
    private String reference;

    /**
     * @ManyToOne = atleast one customer
     */
    @ManyToOne @NotNull
    private CustomerDTO customer;

    /**
     * price
     */
    @NotNull @Min(0)
    private float price;

    /**
     * creation time
     */
    @Column @Past
    private LocalDateTime creationDateTime;

    /**
     * Temporal field
     */
    @Column @Past
    private LocalDateTime validUntilDateTime;

    /**
     * constraint
     */
    @Column @Past
    private LocalDateTime saveDateTime;

    /**
     * Constructor(Quotation)
     * @param id
     * @param reference
     * @param customer
     */
    public Quotation(Long id, String reference, CustomerDTO customer) {
        this.id = id;
        this.reference = reference;
        this.customer = customer;
    }
}
