/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import model.Customer;

/**
 *
 * @author danecek
 */
@Alternative
@Stateless
public class CustomersDAOMock implements CustomersDAOInterface {

    @Inject
    CustomersDB customersDB;

    @Override
    public Collection<Customer> all() {
        return customersDB.getCustomers();
    }

    @Override
    public void create(Customer c) {
        customersDB.addCustomer(c);
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
