<%-- 
    Document   : welcome.jsp
    Created on : Oct 1, 2015, 10:07:40 AM
    Author     : Hau
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome, ${sessionScope.USER} </h1>
        
        <form action="ProcessServlet">
            Last name: <input type="text" name="txtSearchValue" value="" /><br/>
            <input type="submit" value="Search" name="btAction" />
        </form><br/>
        <a href="shopping.html">Click here to buy books</a>
        
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}" >
            <h2>Search Result</h2>
            <c:set var="userList" value="${ requestScope.SEARCHLIST }" />
            <c:if test="${not empty userList}" >
                <c:if test="${true}" >
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Lastname</th>
                                <th>Roles</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" items="${userList}" 
                                       varStatus="counter" >
                                <tr>
                                    <td>
                                        ${counter.count}
                                    .</td>
                                    <td>
                                        ${dto.username}
                                    </td>
                                    <td>
                                        ${dto.password}
                                    </td>
                                    <td>
                                        ${dto.lastname}
                                    </td>
                                    <td>
                                        ${dto.roles}
                                    </td>

                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>

                </c:if>
                <c:if test="${false}" >
                    <h2>No Search Result.</h2>
                </c:if>
            </c:if>
            <c:if test="${empty userList}" >
                <h2>No Search Result.</h2>
            </c:if>
                    
        </c:if>
        
    </body>
</html>
