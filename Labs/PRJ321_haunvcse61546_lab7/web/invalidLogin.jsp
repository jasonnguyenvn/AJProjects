<%-- 
    Document   : invalidLogin
    Created on : Sep 23, 2015, 9:00:55 PM
    Author     : Hau
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.lab5.Account.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login ERROR!!!</title>
    </head>
    <body>
        <c:if test="${ not empty requestScope.ERROROBJ }" >
            <c:if test="${ not empty requestScope.ERROROBJ.getUsernameOrPasswordIncorrect() }" >
                <h1>${ requestScope.ERROROBJ.getUsernameOrPasswordIncorrect() }</h1>
            </c:if>
        </c:if>
        
        
        <h2>Click <a href="index.jsp">here</a> to try again!!!</h2>
    </body>
</html>
