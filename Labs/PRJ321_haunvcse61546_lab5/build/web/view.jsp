<%-- 
    Document   : view
    Created on : Sep 23, 2015, 9:11:33 PM
    Author     : Hau
--%>

<%@page import="lab5.Account.AccountDTO"%>
<%@page import="java.util.List"%>
<%@page import="lab5.Account.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Page</title>
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
        <h1>Information Page</h1>
        
        <form action="Controller" method="GET">
            <%
                String lastSearchValue = request.getParameter("txtSearchValue");
            %>
            
            Lastname <input type="text" name="txtSearchValue" 
                            value="<%
                                if(lastSearchValue!=null) {
                                    out.print(lastSearchValue);
                                }
                            %>" />
            <%
                AccountError erroObj = (AccountError) request.getAttribute("ERROROBJ");
                if(erroObj!=null) {
                    if(erroObj.getSearchFieldNull()!=null) {
                        %>
                        <font color="red">
                            <%= erroObj.getSearchFieldNull()  %>
                        </font>
                        <%
                    }
                }
                
            %>
            <br/>
            <input type="submit" value="Search" name="btAction" />
        </form>
            
        <%
          List<AccountDTO> searchList = (List<AccountDTO>) request.getAttribute("SEARCHLIST");
          if(searchList!=null) {
              %>
              <h2>Result of Searching</h2>
              
              <%
                if(searchList.size()>0) {
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <%
                            
                            String urlRewriting = "Controller?btAction=view"
                                    + "&username=";
                            String urlRewritingPart2 = "&lastSearchValue="
                                    + lastSearchValue;
                            int count = 1;
                            for(AccountDTO acc : searchList) {
                                %>
                                <tr>
                                    <td>
                                        <%= count++ %>
                                    </td>
                                    <td>
                                        <%= acc.getUsername() %>
                                    </td>
                                    <td>
                                        <a href="
                                           <%= urlRewriting+acc.getUsername()
                                                   + urlRewritingPart2
                                           %>
                                           ">ViewDetail</a>

                                    </td>
                                </tr>
                                <%
                            }
                            %>
                        </tbody>
                    </table>

                    <%
                } else {
                    %>
                    <h3>No data for your search value</h3>
                    <%
                }
          }
        %>
        
    </body>
</html>
