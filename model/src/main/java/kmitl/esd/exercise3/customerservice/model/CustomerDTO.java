package kmitl.esd.exercise3.customerservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Customer model
 */

@Setter @Getter
public class CustomerDTO implements Serializable {
    private Long id; // defined id
    private String name; // defined  customer name
    private Long age; // defined age
    private String remark; // defined text

    public CustomerDTO(){ }

    public CustomerDTO(long id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor for customer's DTO class
     * @param id
     * @param name
     * @param age
     * @return void
     */
    public CustomerDTO(long id, String name, long age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Function for printing a customer details
     * @return customer details in string format
     */
    public String toString(){
        return Long.toString(id) + ", " + name + ", " + age;
    }
}



