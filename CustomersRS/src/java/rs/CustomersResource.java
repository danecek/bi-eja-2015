/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import integration.CustomersDAO;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import model.Customer;

/**
 * REST Web Service
 *
 * @author danecek
 */
@Path("customers")
public class CustomersResource {

    @Context
    private UriInfo context;
    @Inject
    CustomersDAO customersDAO;

    /**
     * Creates a new instance of CustomersResource
     */
    public CustomersResource() {
    }

    /**
     * Retrieves representation of an instance of rs.CustomersResource
     *
     * @return an instance of model.Customer
     */
    @GET
    @Produces("application/json")
    public CustomerDTO[] all() {
//        ArrayList<CustomerDTO> dtos = new ArrayList<>();
//        for (Customer c : customersDAO.all()) {
//            dtos.add(new CustomerDTO(c));
//        }
//        return (CustomerDTO[]) dtos.toArray();
       return new CustomerDTO[] { new CustomerDTO(new Customer("Novak", null, 22, null)),
           new CustomerDTO(new Customer("Svoboda", null, 33, null)),
        };
    }

    /**
     * PUT method for updating or creating an instance of CustomersResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(Customer content) {
    }
}
