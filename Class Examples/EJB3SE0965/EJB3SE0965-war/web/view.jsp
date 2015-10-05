<%-- 
    Document   : view
    Created on : Oct 5, 2015, 9:25:31 AM
    Author     : Hau
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
    </head>
    <body>
        <h1>Your cart inclues</h1>
        <c:set var="cart" value="${sessionScope.CART}" />
        
        <c:if test="${not empty cart}">
            <form action="ProcessServlet" method="POST">
            
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cart.items}" varStatus="counter" >
                        <tr>
                            <td>
                                ${counter.count}
                                .</td>
                            <td>
                                ${item.key}
                                
                            </td>
                            <td>
                                ${item.value}
                            </td>
                            <td>
                                <input type="checkbox" name="chkItem" value="${item.key}" />
                            </td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td colspan="3">
                                <a href="shopping.html">Add More Book to Your Cart</a>
                            </td>
                            <td>
                                <input type="submit" value="Remove Items" name="btAction" />
                            </td>
                                
                        </tr>
                </tbody>
            </table>
                
            </form>

        </c:if>
        <c:if test="${empty cart}">
            <h2>Your cart has not existed yet.</h2>
        </c:if>
    </body>
</html>
