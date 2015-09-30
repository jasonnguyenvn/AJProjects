<%-- 
    Document   : viewDetails
    Created on : Sep 23, 2015, 10:20:24 PM
    Author     : Hau
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.SQLException"%>
<%@page import="com.lab5.Account.AccountDAO"%>
<%@page import="com.lab5.Account.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Information Details</title>
</head>
<body>

   <c:if test="${empty sessionScope.LOGINUSEROBJ}" >
       <h1><font color="red">Permission denied.</font></h1>
       <jsp:forward page="403.html" />
    </c:if>
    <c:if test="${not empty sessionScope.LOGINUSEROBJ}" >
        <jsp:useBean id="LOGINUSEROBJ" scope="session" class="com.lab5.javaBeans.AccountBean" />
        <font color="red">
        Welcome ${LOGINUSEROBJ.username}
        </font>
        
        <h1>Information Details</h1>
        
        <jsp:useBean id="viewUser" class="com.lab5.javaBeans.AccountBean" />
        <c:if test="${empty param.username}" >
            <jsp:forward page="400.html" />
        </c:if>
        
        
        <jsp:setProperty name="viewUser" property="username" param="username" />
        
        ${viewUser.getInfo()}
            
        <c:choose>
            <c:when test="${LOGINUSEROBJ.role == false 
                    and 
                    viewUser.username.equals(LOGINUSEROBJ.username) == false
                    }" >
                No permission to access
            </c:when>
            <c:otherwise>
                Username: ${viewUser.username}<br/>
                Lastname: ${viewUser.lastname}<br/>
                Roles: 
                <c:choose>
                    <c:when test="${viewUser.role==true}">
                        Admin
                    </c:when>
                    <c:otherwise>
                        User
                    </c:otherwise>
                </c:choose>
                    
                
            </c:otherwise>
        </c:choose>
        
        <h4>Click 
            <a href="Controller?btAction=Search&txtSearchValue=${param.lastSearchValue}">here</a> 
         to return search page!!!</h4>
    </c:if>

</body>
</html>
