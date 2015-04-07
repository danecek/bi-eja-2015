/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bussines.CustomersFacade;
import bussines.CustomersFacadeQualifier;
import java.util.ArrayList;
import java.util.Collection;
//import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import model.Customer;

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class IndexBean {

    private int beginIndex;
    private int rowsNum = 3;
    @Inject @CustomersFacadeQualifier
    private CustomersFacade customersFacade;

    public IndexBean() {
    }

    /**
     * @return the beginIndex
     */
    public int getBeginIndex() {
        return beginIndex;
    }

    /**
     * @param beginIndex the beginIndex to set
     */
    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    /**
     * @return the rowsNum
     */
    public int getRowsNum() {
        return rowsNum;
    }

    /**
     * @param rowsNum the rowsNum to set
     */
    public void setRowsNum(int rowsNum) {
        this.rowsNum = rowsNum;
    }

    public String next() {
        beginIndex = Math.min(customersFacade.getCustomers().size() - rowsNum, beginIndex + rowsNum);
        return "index";
    }

    public String prev() {
        return "index";
    }

    public String begin() {
        beginIndex = 0;
        return "index";
    }

    public String end() {
        beginIndex = Math.max(0, customersFacade.getCustomers().size() - rowsNum);
        return "index";
    }

    public Collection<Integer> getGroupValues() {
        Collection<Integer> groupValues = new ArrayList<>();
        customersFacade.getCustomers().stream().forEach((c) -> {
            groupValues.add(c.getId());
        });
        return groupValues;
    }

    public Collection<String> getGroupLabels() {
        Collection<String> groupValues = new ArrayList<>();
        customersFacade.getCustomers().stream().forEach((c) -> {
            groupValues.add(c.getGroup().toString());
        });
        return groupValues;
    }

    public Collection<Customer> getCustomers() {
        return customersFacade.getCustomers();
    }

    public Collection<Customer> getGroups() {
        return customersFacade.getCustomers();
    }

}
