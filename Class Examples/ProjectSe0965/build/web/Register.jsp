<%-- 
    Document   : Register
    Created on : Sep 22, 2015, 9:54:50 AM
    Author     : Hau
--%>

<%@page import="User.UserInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign up your account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Sign up your account</h1>
        
        <%
            UserInsertError errObj = (UserInsertError) 
                                            request.getAttribute("INSERTERR");
        %>
        <form action="ControllerServlet" method="POST">
            Username: <input type="text" name="txtUsername" value="" />
            (6 - 20 chars) 
            <% 
                if(errObj!=null) {
                    if(errObj.getUsernameLengthErr()!=null) {
                        %>
                        <font color="red">
                            <%= errObj.getUsernameLengthErr() %>
                        </font>
                        <%
                    } else if(errObj.getUsernameExists()!=null) {
                        %>
                        <font color="red">
                            <%= errObj.getUsernameExists() %>
                        </font>
                        <%
                    }
                }
            %>
            <br />
            Password: <input type="password" name="txtPassword" value="" />
            (6 - 30 chars)
            <% 
                if(errObj!=null) {
                    if(errObj.getPasswordLengthErr()!=null) {
                        %>
                        <font color="red">
                            <%= errObj.getPasswordLengthErr() %>
                        </font>
                        <%
                    }
                }
            %>
            <br />
            Confirm Password: <input type="password" name="txtConfirm" value="" />
            <% 
                if(errObj!=null) {
                    if(errObj.getConfirmNotMatch()!=null) {
                        %>
                        <font color="red">
                            <%= errObj.getConfirmNotMatch() %>
                        </font>
                        <%
                    }
                }
            %>
            <br/>
            Full name: <input type="text" name="txtFull" value="" />
            <% 
                if(errObj!=null) {
                    if(errObj.getLastnameLengthErr()!=null) {
                        %>
                        <font color="red">
                            <%= errObj.getLastnameLengthErr() %>
                        </font>
                        <%
                    }
                }
            %>
            <br/>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
