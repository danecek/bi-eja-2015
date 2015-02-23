<%-- 
    Document   : AddCustomer
    Created on : Feb 23, 2015, 2:06:40 PM
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
        <h1>Add Customer</h1>

        <jsp:useBean id= "validator" class= "model.CustomerValidator" scope="request"/>

        <form action="addCustomer.do" method="post">
            <input type="text" name="name" value="${requestScope.validator.namePar}" /><br>
            <input type="text" name="age" value="${requestScope.validator.agePar}" /><br>
            <c:if test="${not empty requestScope.validator.errorMessages}">
                <ul>
                    <c:forEach var="error" items="${requestScope.validator.errorMessages}">
                        <li>
                            ${error}
                        </li>
                    </c:forEach> 
                </ul>
            </c:if>
            <input type="submit" value="Add" />
        </form>
    </body>
</html>
