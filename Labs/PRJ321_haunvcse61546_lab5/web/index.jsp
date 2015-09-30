<%-- 
    Document   : index
    Created on : Sep 23, 2015, 3:48:10 PM
    Author     : Hau
--%>

<%@page import="lab5.Account.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        
        <form action="Controller" method="POST">
            <%
                String txtUsername = request.getParameter("txtUsername");
            %>
            Username <input type="text" name="txtUsername" 
                            value="<%
                                if(txtUsername!=null) {
                                    out.print(txtUsername);
                                }
                            %>" />
            <%
                AccountError erroObj = (AccountError) request.getAttribute("ERROROBJ");
                
                if(erroObj!=null) {
                    if(erroObj.getUsernameFieldNull()!=null) {
                        %>
                        <font color="red">
                        <%= erroObj.getUsernameFieldNull()  %>
                        </font>
                        <%
                    }
                }
            %>
            <br/>
            Password <input type="password" name="txtPassword" value="" />
            <%
                if(erroObj!=null) {
                    if(erroObj.getPasswordFieldNull()!=null) {
                        %>
                        <font color="red">
                        <%= erroObj.getPasswordFieldNull() %>
                        </font>
                        <%
                    }
                }
            %>
            <br/>
            <input type="submit" value="Login" name="btAction" />
        </form>
    </body>
</html>
