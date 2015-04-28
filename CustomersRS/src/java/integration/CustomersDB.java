/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import model.Customer;
import model.Group;

/**
 *
 * @author danecek
 */
@Singleton
public class CustomersDB {

    NavigableMap<Integer, Customer> customers = new TreeMap<>();
    NavigableMap<Integer, Group> groups = new TreeMap<>();

    private Group addGroup(int id, String name) {
        Group g = new Group(id, name);
        groups.put(g.getId(), g);
        return g;
    }

    @PostConstruct
    void init() {
        addGroup(1, "Red");
        addGroup(2, "Blue");
        addGroup(3, "Green");
        addGroup(4, "Magenta");
        addCustomer("Novak", "Novak@gmail.com", 33, 1);
        addCustomer("Svoboda", "Svoboda@gmail.com", 22, 2);
        addCustomer("Cerny", "Cerny@gmail.com", 70, 2);
        addCustomer("Pilny", "Pilny@gmail.com", 3, 4);
    }

    @Lock(LockType.WRITE)
    public void addCustomer(String name, String email,
            int age, int groupId) {
        Integer last = 0;
        if (!customers.isEmpty()) {
            last = customers.lastKey();
        }
        Customer c = new Customer(last + 1, name, email, age, groups.get(groupId));
        customers.put(c.getId(), c);
    }
    @Lock(LockType.WRITE)
    public void addCustomer(Customer c) {
        Integer last = 0;
        if (!customers.isEmpty()) {
            last = customers.lastKey();
        }
        c.setId(last + 1);
        customers.put(c.getId(), c);
    }

    @Lock(LockType.READ)
    public Collection<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Lock(LockType.READ)
    public Customer find(int id) {
        return customers.get(id);
    }

    @Lock(LockType.WRITE)
    public void delete(int id) {
        customers.remove(id);
    }

    @Lock(LockType.READ)
    public Collection<Group> getGroups() {
        return new ArrayList<>(groups.values());
    }

}
