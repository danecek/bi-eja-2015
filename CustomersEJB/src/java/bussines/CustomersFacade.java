package bussines;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJBContext;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import model.Customer;
import model.Group;

@Stateless
public class CustomersFacade {

    //  @EJB
    CustomersDB customersDB;
    @Resource
    EJBContext context;

    public void addCustomer(String name, String email,
            int age, int groupId) {
        customersDB.addCustomer(name, email, age, groupId);
    }

    @PostConstruct
    void init() {
        customersDB = (CustomersDB) context.lookup("java:global/CustomersEJB/CustomersDB");
    }

    public Collection<Customer> getCustomers() {
        return customersDB.getCustomers();
    }

    public void delete(int id) {
        customersDB.delete(id);
    }

    public Collection<Group> getGroups() {
        return customersDB.getGroups();
    }

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        Logger.getAnonymousLogger().log(Level.INFO, ic.getMethod().getName());
        return ic.proceed();
    }

    public Customer find(int id) {
        return customersDB.find(id);
    }

    @Schedule(second = "*", minute = "*", hour = "*", persistent = false)
    void x() {
        Logger.getAnonymousLogger().log(Level.INFO, new Date().toString());
    }

    @Asynchronous
    public Future<Integer> f() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CustomersFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>(1);
    }

}
