/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerswsclient;

import customersws.Customer;
import customersws.CustomersWS_Service;
import customersws.GetCustomers;
import customersws.GetCustomersResponse;
import customersws.ObjectFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;

/**
 *
 * @author danecek
 */
public class CustomersWSClient extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println(getCustomers());
                getCustomers();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private static List<Customer> getCustomers() {
        try {
            CustomersWS_Service service = new CustomersWS_Service();
            JAXBContext jaxbc = JAXBContext.newInstance("customersws");
            Dispatch<Object> disp = service.createDispatch(new QName("http://ws/", "CustomersWSPort"), jaxbc, Service.Mode.PAYLOAD);
            disp.invokeAsync(new ObjectFactory().createGetCustomers(new GetCustomers()), new AsyncHandler<Object>() {

                @Override
                public void handleResponse(Response<Object> response) {
                    GetCustomersResponse gcr = (GetCustomersResponse) ((JAXBElement) response).getValue();
                    System.out.println(gcr.getReturn());
                }
            });
        } catch (JAXBException ex) {
            Logger.getLogger(CustomersWSClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    private static String getCustomers() {
//        try {
//            CustomersWS_Service service = new CustomersWS_Service();
//            Dispatch<Source> disp = service.createDispatch(new QName("http://ws/", "CustomersWSPort"), Source.class, Service.Mode.PAYLOAD);
//            Source responseSource = disp.invoke(new StreamSource(new StringReader("<ns2:getCustomers xmlns:ns2=\"http://ws/\"/>")));
//            Transformer t = TransformerFactory.newInstance().newTransformer();
//            StringWriter sr;
//            t.transform(responseSource, new StreamResult(sr = new StringWriter()));
//            return sr.toString();
////        CustomersWS port = service.getCustomersWSPort();
////        return port.getCustomers();
//        } catch (TransformerConfigurationException ex) {
//            Logger.getLogger(CustomersWSClient.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TransformerException ex) {
//            Logger.getLogger(CustomersWSClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
}
