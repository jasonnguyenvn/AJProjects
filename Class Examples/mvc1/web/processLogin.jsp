<%-- 
    Document   : processLogin
    Created on : Sep 23, 2015, 9:18:36 AM
    Author     : Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing</title>
    </head>
    <body>
        <h1>Login Processing</h1>
        
        <jsp:useBean id="loginAttr" class="sample.javabeans.LoginBean" 
                     scope="session" />
        
        
        <%--
        <jsp:setProperty name="loginAttr" property="username"
            value='<%= request.getParameter("txtUsername") %>' />
            
        <jsp:setProperty name="loginAttr" property="password"
            value='<%= request.getParameter("txtPassword") %>' />
        //
        <jsp:setProperty name="loginAttr" property="username"
                         param="txtUsername" />
            
        <jsp:setProperty name="loginAttr" property="password"
                         param="txtPassword" />
        //
         <jsp:setProperty name="loginAttr" property="username" />
        <jsp:setProperty name="loginAttr" property="password"  />
        --%>
        
       
        <jsp:setProperty name="loginAttr" property="*" />
        
            
        <%--
        Test value: <br/>
        Username: <jsp:getProperty name="loginAttr" property="username" /><br/>
        Password: <jsp:getProperty name="loginAttr" property="password" /><br/>
        --%>
        
        
        <%--
        <%
            if(loginAttr.checkLogin()) {
                //response.sendRedirect("welcome.jsp");
                // return;
        %>
                <jsp:forward page="welcome.jsp">
                    <jsp:param name="var1" value="jsp" />
                    <jsp:param name="var2" value="forward" />
                </jsp:forward>
               

        <%
            }
        %>
        --%>
        

        <%--
        <jsp:param name="var1" value="jsp" />
        <jsp:param name="var2" value="forward" />
        --%>


        <c:if test="${loginAttr.checkLogin()}" >
                <jsp:forward page="welcome.jsp">
                    <jsp:param name="var1" value="jsp" />
                    <jsp:param name="var2" value="forward" />
                </jsp:forward>
               
        </c:if>
        <h2><font color="red">Invalid username or password.</font></h2>
        
    </body>
</html>
