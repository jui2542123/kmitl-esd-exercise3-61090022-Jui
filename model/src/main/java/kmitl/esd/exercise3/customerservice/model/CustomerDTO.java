package kmitl.esd.exercise3.customerservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Customer model
 */

@Setter @Getter
public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private Long age;
    private String remark;

    public CustomerDTO(){ }

    public CustomerDTO(long id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor
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
     * print details
     * @return customer details in string format
     */
    public String toString(){
        return Long.toString(id) + name + age;
    }
}



