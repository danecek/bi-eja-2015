
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import model.Customer;

public class CustomerDTO {

    public Integer id;
    public String name;
    public String email;
    public int age;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer c) {
        this.name = c.getName();
    }

}
