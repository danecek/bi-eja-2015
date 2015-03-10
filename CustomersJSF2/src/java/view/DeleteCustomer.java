/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.CustomerDB;

/**
 *
 * @author danecek
 */
@ManagedBean
@RequestScoped
public class DeleteCustomer {

    @ManagedProperty(value = "#{applicationScope.customerDB}")
    private CustomerDB customerDB;
    
    @ManagedProperty(value = "#{param.id}")
    private int id;

    /**
     * Creates a new instance of DeleteCustomer
     */
    public DeleteCustomer() {
    }

    public String delete() {
        getCustomerDB().delete(id);
        return "index?faces-redirect=true";
    }

    public String delete(int id) {
        getCustomerDB().delete(id);
        return "index?faces-redirect=true";
    }
    /**
     * @return the customerDB
     */
    public CustomerDB getCustomerDB() {
        return customerDB;
    }

    /**
     * @param customerDB the customerDB to set
     */
    public void setCustomerDB(CustomerDB customerDB) {
        this.customerDB = customerDB;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
