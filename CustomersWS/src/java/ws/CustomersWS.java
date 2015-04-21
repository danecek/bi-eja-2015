/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bussines.CustomersFacade;
import bussines.CustomersFacadeQualifier;
import java.util.Collection;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.Customer;
import model.Group;

/**
 *
 * @author danecek
 */
@WebService(serviceName = "CustomersWS")
public class CustomersWS {

    @Inject
    @CustomersFacadeQualifier

    private CustomersFacade facade;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addCustomer")
    public Customer addCustomer(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "age") int age, @WebParam(name = "groupId") int groupId) {
        return facade.addCustomer(name, email, age, groupId);
    }

    @WebMethod(operationName = "getCustomers")
    public Collection<Customer> getCustomers() {
        return facade.getCustomers();
    }

//    @WebMethod(operationName = "delete")
//    @Oneway
//    public void delete(@WebParam(name = "id") int id) {
//        facade.delete(id);
//    }
//
//    @WebMethod(operationName = "getGroups")
//    public Collection<Group> getGroups() {
//        return facade.getGroups();
//    }
//
//    @WebMethod(operationName = "log")
//    public Object log(@WebParam(name = "ic") InvocationContext ic) throws Exception {
//        return facade.log(ic);
//    }
//
//    @WebMethod(operationName = "findCustomer")
//    public Customer findCustomer(@WebParam(name = "id") int id) {
//        return facade.findCustomer(id);
//    }
//
//    @WebMethod(operationName = "updateGroup")
//    @Oneway
//    public void updateGroup(@WebParam(name = "custId") int custId, @WebParam(name = "groupId") int groupId) {
//        facade.updateGroup(custId, groupId);
//    }
//
//    @WebMethod(operationName = "f")
//    public Future<Integer> f() {
//        return facade.f();
//    }

}
