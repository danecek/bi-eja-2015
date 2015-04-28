/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customersrsclient;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author danecek
 */
public class CustomersRSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        // URI uri = UriBuilder.fromPath("http://localhost/CustomersRS/webresources/customers").port(8080).build();
        WebTarget wt = client.target("http://localhost:8080").path("/CustomersRS/webresources/customers");

        Invocation.Builder b = wt.request(MediaType.APPLICATION_JSON);
        Response resp = b.get();
        List<CustomerDTO> res = resp.readEntity(new GenericType<List<CustomerDTO>>() {
        });

        System.out.println(res);
        // TODO code application logic here
    }

}
