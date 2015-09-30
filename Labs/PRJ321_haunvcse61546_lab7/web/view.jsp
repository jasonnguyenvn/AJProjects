<%-- 
    Document   : view
    Created on : Sep 23, 2015, 9:11:33 PM
    Author     : Hau
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="mtag" %>
<%@page import="com.lab5.Account.AccountDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.lab5.Account.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Information Page</title>
</head>
<body>
    <c:if test="${empty sessionScope}" >
        <h1><font color="red">Permission denied.</font></h1>
    </c:if>
        
    <jsp:useBean id="LOGINUSEROBJ" scope="session" class="com.lab5.javaBeans.AccountBean" />
    
    <c:if test="${empty LOGINUSEROBJ}" >
       <h1><font color="red">Permission denied.</font></h1>
    </c:if>
    <c:if test="${not empty LOGINUSEROBJ}" >

        <font color="red">
        Welcome ${LOGINUSEROBJ.username}
        </font>

        <h1>Information Page</h1>

        <form action="" method="GET">

            Lastname 
            <c:if test="${not empty param.txtSearchValue}" >
                <input type="text" name="txtSearchValue"  
                       value="${param.txtSearchValue}" />
            </c:if>
            <c:if test="${empty param.txtSearchValue}" >
                <input type="text" name="txtSearchValue"  value="" />
            </c:if>
            <c:if test="${not empty parm.txtSearchValue}" >
                <c:if test='${param.txtSearchValue.equals("")}' >
                    <font color="red">
                        Last Name field cannot be nulll.
                    </font>
                </c:if>
            </c:if>
                
            <%--
            <c:if test="${not empty requestScope.ERROROBJ}" >
                <c:if test="${not empty requestScope.ERROROBJ.getSearchFieldNull()}" >
                    <font color="red">
                        ${requestScope.ERROROBJ.getSearchFieldNull()}
                    </font>
                </c:if>
            </c:if>
            
            --%>
            
                    
            <br/>
            <input type="submit" value="Search" name="btAction" />
        </form>
        
        <c:if test="${not empty param.txtSearchValue}" >
            <h2>Result of Searching</h2>
            <mtag:AccountGrid dataSource="PRJ321_SE61546_lab5"
            sqlStatement="SELECT * FROM TBL_Account WHERE Lastname LIKE ? "
            lastNameRef="%${param.txtSearchValue}%"
                          />
        </c:if>
        
        
        <%-- 
        <c:if test="${not empty requestScope.SEARCHLIST}"   >
            <h2>Result of Searching</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.SEARCHLIST}" varStatus="counter" >
                        <tr>
                            <td>
                                ${counter.count}
                            .</td>
                            <td>
                                ${dto.username}
                            </td>
                            <td>
                                <a href="Controller?btAction=view&username=${dto.username}&lastSearchValue=${param.txtSearchValue}">
                                    ViewDetail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        --%>



    </c:if>


</body>
</html>
