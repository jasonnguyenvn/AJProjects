<%-- 
    Document   : search
    Created on : Sep 22, 2015, 8:53:38 AM
    Author     : Hau
--%>

<%@page import="User.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <%--
        <font color="red">Welcome, <%= session.getAttribute("USER") %></font>
        --%>
        <font color="red">Welcome, ${sessionScope.USER}</font>
        <h1>Search Page</h1>
        
        <form action="ControllerServlet">
            Last Name: <input type="text" name="txtSearchValue" value="" />
            <input type="submit" value="Search" name="btAction" />
        </form>
        <a href="shoppingCart.html">Click here to buy books</a>
        <br/>
        
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.usrList}" />
            <c:if test="${not empty result}" >
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
                        <c:forEach var="dto" items="${result}" 
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
            <c:if test="${empty result}" >
                <h2>No record is matched.</h2>
            </c:if>
        </c:if>
        
        <%--
        <%
        
        String searchValue = request.getParameter("txtSearchValue");
        if(searchValue != null) {
            %>
            <h2>Search Result</h2>
            <%
            try {
                List<UserDTO> usrList = (List<UserDTO>) request.getAttribute("usrList");
                    if(usrList.size()>0) {
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Last name</th>
                                <th>Roles</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <%
                    int count = 1;
                    for(UserDTO user : usrList) {
                        // Resuource?name=value&...
                        String urlRewriting = "ControllerServlet?btAction=del"
                                                + "&pk="+user.getUsername()
                                                + "&lastSearchValue=" 
                                                + searchValue;
                        %>
                        
                        <form action='ControllerServlet' method='POST'>
                        <tr>
                            <td>
                                <%= count++ %>
                                .</td>
                            <td>
                                <%= user.getUsername() %>
                                <input type="hidden" name="pk" 
                                       value="<%= user.getUsername() %>" />
                            </td>
                            <td>
                                
                                <input type="password" name="txtPassword" 
                                       value="<%= user.getPassword() %>" />
                            </td>
                            <td>
                                <%= user.getLastname() %>
                            </td>
                            <td>
                                <%
                        if(user.isAdmin()) {
                              %>
                              <input type="checkbox" name="chkAdmin" 
                                     value="ADMIN" checked="checked" />

                              <%
                        } else {
                            %>
                            <input type="checkbox" name="chkAdmin" 
                                     value="ADMIN" />
                            <%
                        }
                                %>
                            </td>
                            <td>
                                <a href="<%= urlRewriting %>">Delete</a>
                            </td>
                            <td>
                                <input type="submit" value="Update" name="btAction" />
                                <input type="hidden" name="lastSearchValue" 
                                       value="<%= searchValue %>" />
                            </td>
                        </tr>
                        </form>
                        <%
                    }
                            %>
                        </tbody>
                    </table>

                    <%
                    
                 }
            } catch (NullPointerException e) {
                e.printStackTrace();

            }
        }
        %>
        
        --%>
    </body>
</html>