/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Customer;

/**
 *
 * @author danecek
 */
//@Stateless
public class CustomersDAO implements CustomersDAOInterface {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public void create(Customer c) {
       em.persist(c);
    }
    
    @LogInterceptorBinding
    @Override
    public Collection<Customer> all() {
        // TypedQuery<Customer> tq = em.createQuery("SELECT c FROM CUST c", Customer.class);
        TypedQuery<Customer> tq = em.createNamedQuery("allCustomers", Customer.class);
        return tq.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void delete(int id) {
        em.remove(find(id));
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer find(int id) {
        return em.find(Customer.class, id);
    }
}
