/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@NamedQuery(name = "allCustomers", query = "SELECT c FROM CUST c")
@Entity(name = "CUST")
public class Customer {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private int age;
    
    @ManyToOne
    private Group group;
    
    public Customer() {
    }
    
    public Customer(String name, String email, int age, Group group) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.group = group;
        
    }

    public Customer(Integer id, String name, String email, int age, Group group) {
        this(name, email, age, group);
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        this.group = group;
    }
    
}
