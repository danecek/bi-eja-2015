/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bussines.CustomersFacade;
import bussines.CustomersFacadeQualifier;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import model.Customer;
import model.Group;

/**
 *
 * @author danecek
 */
@Named(value = "addCustomerBean")
@ConversationScoped
public class AddCustomerBean implements Serializable {

    private String name;
    private String email;
    private int age;
    private int groupId;
    @Inject
    @CustomersFacadeQualifier
    private CustomersFacade customersFacade;
    @Inject
    Conversation conversation;
    private Customer lastCustomer;

    /**
     * Creates a new instance of AddCustomerBean
     */
    @PostConstruct
    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()
                && conversation.isTransient()) {

            conversation.begin();
        }
    }

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
        lastCustomer = customersFacade.addCustomer(getName(), getEmail(), getAge(), getGroupId());
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

    public Customer getLastCustomer() {
        Customer lc = lastCustomer;
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return lc;
    }

}
