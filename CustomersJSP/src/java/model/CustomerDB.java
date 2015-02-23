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

/**
 *
 * @author danecek
 */
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

    public Collection<Customer> allCustomers() {
        return new ArrayList<>(customers.values());
    }

}
