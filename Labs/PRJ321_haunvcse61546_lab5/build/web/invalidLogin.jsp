<%-- 
    Document   : invalidLogin
    Created on : Sep 23, 2015, 9:00:55 PM
    Author     : Hau
--%>

<%@page import="lab5.Account.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login ERROR!!!</title>
    </head>
    <body>
        <h1><%
            AccountError errObj = (AccountError) request.getAttribute("ERROROBJ");
            if(errObj.getUsernameOrPasswordIncorrect()!=null) {
                out.print(errObj.getUsernameOrPasswordIncorrect());
            }
        %></h1>
        
        <h2>Click <a href="index.jsp">here</a> to try again!!!</h2>
    </body>
</html>
