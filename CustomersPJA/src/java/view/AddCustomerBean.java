/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bussines.CustomersFacade;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Group;

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
    private int groupId;
    @EJB
    private CustomersFacade customersFacade;

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
        customersFacade.addCustomer(getName(), getEmail(), getAge(), getGroupId());
        return "index?faces-redirect=true";
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

     /**
     * @return the groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    public Collection<Group> getGroups() {
        return customersFacade.getGroups();
    }

}
