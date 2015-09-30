<%-- 
    Document   : processLogin
    Created on : Sep 26, 2015, 12:30:32 PM
    Author     : Hau
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="LOGINUSEROBJ" scope="session" class="com.lab5.javaBeans.AccountBean" />

<jsp:setProperty name="LOGINUSEROBJ" property="username" param="txtUsername" />
<jsp:setProperty name="LOGINUSEROBJ" property="password" param="txtPassword" />

<c:if test="${LOGINUSEROBJ.checkLogin()}" >
    <jsp:forward page="view.jsp" />
</c:if>
<c:if test="${LOGINUSEROBJ.checkLogin() == false}" >
    
    ${requestScope.ERROROBJ.setUsernameOrPasswordIncorrect("Invalid username or password!!!!!")}
    <jsp:forward page="invalidLogin.jsp" />
</c:if>

