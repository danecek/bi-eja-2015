/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author danecek
 */
@ManagedBean(name = "customerDB")
@ApplicationScoped
public class CustomerDB {

    NavigableMap<Integer, Customer> customers = new TreeMap<>();

    public CustomerDB() {
        addCustomer("Novak", 33);
    }

    public synchronized void addCustomer(String name, int age) {
        Integer last = 0;
        if (!customers.isEmpty())
          last = customers.lastKey();
        Customer c = new Customer(last + 1, name, age);
        customers.put(c.getId(), c);
    }

    public Collection<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }
    
    public Customer find(int id) {
        return customers.get(id);
    }

    public void delete(int id) {
        customers.remove(id);
    }

}
