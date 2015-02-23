<%-- 
    Document   : Customers
    Created on : Feb 23, 2015, 1:44:36 PM
    Author     : danecek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customers</h1>
        <jsp:useBean id="customerDB" class="model.CustomerDB" scope="application" />
        <table>
            <c:forEach var="customer" items="${customerDB.allCustomers()}">
                <tr>
                    <td>
                        ${customer.id}                        
                    </td>

                    <td>
                        ${customer.name}                        
                    </td>
                    <td>
                        ${customer.age}                        
                    </td>
                </tr>   
            </c:forEach>
        </table>
        <div>
            <a href="AddCustomer.jsp">Add Customer</a>
        </div>
    </body>
</html>
