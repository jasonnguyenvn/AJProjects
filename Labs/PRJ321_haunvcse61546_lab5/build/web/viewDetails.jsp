<%-- 
    Document   : viewDetails
    Created on : Sep 23, 2015, 10:20:24 PM
    Author     : Hau
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="lab5.Account.AccountDAO"%>
<%@page import="lab5.Account.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Details</title>
    </head>
    <body>
        <font color="red">
        <%
            if(session==null) {
                out.println("<h1>Permission denied.</h1></body></html>");
                return;
            }
            AccountDTO userObj = (AccountDTO) session.getAttribute("LOGINUSEROBJ");
            
            if(userObj==null) {
                out.println("<h1>Permission denied.</h1></body></html>");
                return;
            }
            
            out.println("Welcome " + userObj.getUsername());
            
        %>
        </font>
        
        <h1>Information Details</h1>
        <%
            String pkUsername = request.getParameter("username");
            if(userObj.isAdmin()==false
                    && userObj.getUsername().equals(pkUsername)==false) {
                %>
                No permission to access
                <%
            } else {
            
                AccountDAO dao = new AccountDAO();
                AccountDTO user = null;
                try {
                    user = dao.getUserByUsername(pkUsername);
                } catch(ClassNotFoundException ex) {
                    log(ex.getMessage());
                } catch(SQLException ex) {
                    log(ex.getMessage());
                }

                if(user==null) {
                    response.sendError(404);
                }

                %>

                Username:  <%= user.getUsername() %><br/>
                Lastname: <%= user.getLastname() %> <br/>
                Roles:  
                <%
                if(user.isAdmin()==true) {
                    out.print("Admin");
                } else {
                    out.print("User");
                }
            
            }
            
            String lastSearchValue = request.getParameter("lastSearchValue");
            String urlRewriting = "Controller?btAction=";
            if(lastSearchValue!=null) {
                urlRewriting += "Search&txtSearchValue="+lastSearchValue;
            } else {
                urlRewriting += "infoPage";
            }

        %>
        
        <h4>Click 
            <a href="<%= urlRewriting %>">here</a> 
         to return search page!!!</h4>
    </body>
</html>
