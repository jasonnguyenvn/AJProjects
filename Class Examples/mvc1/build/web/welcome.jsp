<%-- 
    Document   : welcome
    Created on : Sep 23, 2015, 9:38:40 AM
    Author     : Hau
--%>

<%@page import="sample.javabeans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="/WEB-INF/tlds/customTag.tld" prefix="t" %>
<%@taglib  tagdir="/WEB-INF/tags/" prefix="myTag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <font color="red">Welcome,
        <%= ((LoginBean) session.getAttribute("loginAttr")).getUsername() %></font>
        
        <jsp:useBean id="loginAttr" class="sample.javabeans.LoginBean" 
                     scope="session" /> 
        <br/>
        <font color="green">
        Welcome, 
        <jsp:getProperty name="loginAttr" property="username"/>
        </font>
        
        <font color="blue">
        Welcome, ${sessionScope.loginAttr.username}
        </font>
        
        <font color="yellow">
        Welcome, ${loginAttr.username}
        </font>
        
        <h1>Welcome to MVC1</h1>
        
        Var1 = ${param.var1} <br/>
        Var2 = ${param.var2} <br/>
        
        <t:customTagHandle  />
        
        <!--
        var1 = <%= request.getParameter("var1") %><br/>
        var2 = <%= request.getParameter("var2") %>
        
        -->
        
        <myTag:myGrid dataSource="ProjectJWeb" sqlStatement="SELECT username as"  />
    </body>
</html>
