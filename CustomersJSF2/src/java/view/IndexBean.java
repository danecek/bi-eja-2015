/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Customer;
import model.CustomerDB;

/**
 *
 * @author danecek
 */
@ManagedBean
@SessionScoped
public class IndexBean {

    private int beginIndex;
    private int rowsNum = 3;
    @ManagedProperty(value = "#{customerDB}")
    private CustomerDB customerDB;

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
        beginIndex = Math.min(getCustomerDB().getCustomers().size() - rowsNum, beginIndex + rowsNum);
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
        beginIndex = Math.max(0, getCustomerDB().getCustomers().size() - rowsNum);
        return "index";
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

    public Collection<Integer> getGroupValues() {
        Collection<Integer> groupValues = new ArrayList<>();
        customerDB.getCustomers().stream().forEach((c) -> {
            groupValues.add(c.getId());
        });
        return groupValues;
    }

    public Collection<String> getGroupLabels() {
        Collection<String> groupValues = new ArrayList<>();
        customerDB.getCustomers().stream().forEach((c) -> {
            groupValues.add(c.getGroup().toString());
        });
        return groupValues;
    }

}
