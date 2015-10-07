<%-- 
    Document   : welcome
    Created on : Oct 7, 2015, 9:11:43 AM
    Author     : Hau
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        Welcome, ${ sessionScope.USERNAME }
        
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${empty searchValue}" >
            <form action="ProcessServlet">
                Lastname <input type="text" name="txtSearchValue" value="" />
                <input type="submit" value="Search" name="btAction" />
            </form>
        </c:if>
        <c:if test="${not empty searchValue}" >
            <form action="ProcessServlet">
                Lastname <input type="text" name="txtSearchValue" value="${searchValue}" />
                <input type="submit" value="Search" name="btAction" />
            </form>
            
                <h2>Search result</h2>
                <c:set var="userList" value="${requestScope.USERLIST}" />
                <c:if test="${empty userList}" >
                    No result matched.
                </c:if>
                <c:if test="${not empty userList}" >
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Lastname</th>
                                <th>Role</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${userList}" varStatus="counter">
                                <form action="ProcessServlet" method="POST">
                                <TR>
                                    <td>
                                        ${counter.count}
                                    .</td>
                                    <td>
                                        ${item.username}
                                    </td>
                                    <td>
                                        ${item.password}
                                    </td>
                                    <td>
                                        ${item.lastname}
                                    </td>
                                    <td>
                                        ${item.isAdmin}
                                    </td>
                                    <td>
                                        
                                        <c:url value="/ProcessServlet?btAction=Delete&pk=${item.username}" 
                                               var="urlRewriting" />
                                        
                                        <a href="${urlRewriting}">Delete</a>
                                    </td>
                                </TR>
                                <!-- -->

                                </form>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                </c:if>
                

                
        </c:if>
        
    </body>
</html>
