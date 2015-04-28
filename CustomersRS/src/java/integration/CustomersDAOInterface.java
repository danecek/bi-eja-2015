/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.Collection;
import model.Customer;

/**
 *
 * @author danecek
 */
public interface CustomersDAOInterface {

    Collection<Customer> all();

    void create(Customer c);

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    void delete(int id);

    Customer find(int id);
    
}
