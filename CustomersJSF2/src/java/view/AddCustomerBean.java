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
public class AddCustomerBean {

    private String name;
    private String email;
    private int age;
    @ManagedProperty(value = "#{applicationScope.customerDB}")
    private CustomerDB customerDB;

    /**
     * Creates a new instance of AddCustomerBean
     */
    public AddCustomerBean() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String submit() {
        getCustomerDB().addCustomer(getName(), getEmail(), getAge());
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
