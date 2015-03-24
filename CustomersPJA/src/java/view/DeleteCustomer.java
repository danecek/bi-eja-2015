/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bussines.CustomersFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Customer;

/**
 *
 * @author danecek
 */
@ManagedBean
@RequestScoped
public class DeleteCustomer {

    @EJB
    private CustomersFacade customersFacade;

   // @ManagedProperty(value = "#{param.id}")
    private int id;
    
    private Customer customer;
    
    @PostConstruct
    void init() {
        id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
        customer = customersFacade.findCustomer(id);
    }

    /**
     * Creates a new instance of DeleteCustomer
     */
    public DeleteCustomer() {
    }

    public String delete() {
        customersFacade.delete(id);
        return "index?faces-redirect=true";
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

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
