package bussines;

import integration.CustomersDAO;
import integration.CustomersDAOInterface;
import integration.GroupsDAO;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import model.Customer;
import model.Group;

@Stateless
@CustomersFacadeQualifier
public class CustomersFacade {

    @Inject
    CustomersDAOInterface customersDAO;
    @Inject
    GroupsDAO groupsDAO;
    @Resource
    EJBContext context;

    public Customer addCustomer(String name, String email,
            int age, int groupId) {
        Group g = groupsDAO.find(groupId);
        Customer c = new Customer(name, email, age, g);
        customersDAO.create(c);
        return c;
    }
//    public void addCustomer(Customer c) {
//        Group g = groupsDAO.find(groupId);
//        c.setGroup(g);
//        customersDAO.create(c);
//    }

//    @PostConstruct
//    void init() {
//        customersDB = (CustomersDB) context.lookup("java:global/CustomersEJB/CustomersDB");
//    }
    public Collection<Customer> getCustomers() {
        return customersDAO.all();
    }

    public void delete(int id) {
        customersDAO.delete(id);
    }

    public Collection<Group> getGroups() {
        return groupsDAO.all();
    }

//    @AroundInvoke
//    public Object log(InvocationContext ic) throws Exception {
//        Logger.getAnonymousLogger().log(Level.INFO, ic.getMethod().getName());
//        return ic.proceed();
//    }

    public Customer findCustomer(int id) {
        return customersDAO.find(id);
    }

//    @Schedule(second = "*", minute = "*", hour = "*", persistent = false)
//    void x() {
//        Logger.getAnonymousLogger().log(Level.INFO, new Date().toString());
//    }
    public void updateGroup(int custId, int groupId) {
        Customer c = findCustomer(custId);
        Group oldGroup = c.getGroup();
        oldGroup.getCustomers().remove(c);
        Group newGgroup = findGroup(groupId);
        newGgroup.getCustomers().add(c);
        c.setGroup(newGgroup);
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

    private Group findGroup(int groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
