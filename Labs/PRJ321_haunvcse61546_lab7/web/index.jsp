<%-- 
    Document   : index
    Created on : Sep 23, 2015, 3:48:10 PM
    Author     : Hau
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.lab5.Account.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        
        <jsp:useBean id="LOGINUSEROBJ" scope="session" class="com.lab5.javaBeans.AccountBean" />
        
        <c:if test="${LOGINUSEROBJ.checkLogin()}" >
            <jsp:forward page="view.jsp" />
        </c:if>
        <c:if test="${LOGINUSEROBJ.checkLogin() == false}" >
            <form action="Controller" method="POST">
            
            Username 
            <c:if test="${ not empty param.txtUsername }" >
                <input type="text" name="txtUsername" value="${param.txtUsername}" />
            </c:if>
            <c:if test="${ empty param.txtUsername }" >
                <input type="text" name="txtUsername" value="" />
            </c:if>
                
            <c:if test="${not empty requestScope.ERROROBJ }" >
                <c:if test="${not empty requestScope.ERROROBJ.getUsernameFieldNull()}" >
                    <font color="red">
                        ${requestScope.ERROROBJ.getUsernameFieldNull()}
                    </font>
                </c:if>
            </c:if>
            <br/>
            Password <input type="password" name="txtPassword" value="" />
            <c:if test="${not empty requestScope.ERROROBJ }" >
                <c:if test="${not empty requestScope.ERROROBJ.getPasswordFieldNull()}" >
                    <font color="red">
                        ${requestScope.ERROROBJ.getPasswordFieldNull()}
                    </font>
                </c:if>
            </c:if>
            <br/>
            <input type="submit" value="Login" name="btAction" />
        </form>
            
        </c:if>
        
            
            
    </body>
</html>
