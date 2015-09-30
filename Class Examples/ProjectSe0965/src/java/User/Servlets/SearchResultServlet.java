/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User.Servlets;

import User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hau
 */
public class SearchResultServlet extends HttpServlet {
    
    protected void processPrintSearchResult(String username, 
                                HttpServletRequest request, PrintWriter out ) {
        out.println( "NUMBER OF RESULT: " );
        
        try {
            List<UserDTO> usrList = (List<UserDTO>) request.getAttribute("usrList");
            
            if(usrList==null)  {
                out.println( " 0");
                return;
            }
            
            int noOfUsr = usrList.size();
            out.println( noOfUsr + "<br />");
            
            out.println( "<table border=\"1\" >");
            out.println( "<thead>");
            out.println( "<tr>");
            out.println( "<th>No</th>");
            out.println( "<th>User Name</th>");
            out.println( "<th>Password</th>");
            out.println( "<th>Last name</th>");
            out.println( "<th>Role</th>");
            out.println( "<th>Delete</th>");
            out.println( "<th>Update</th>");
            out.println( "</tr>");
            out.println( "</thead><tbody>");
            
            int count = 1;
            for(UserDTO user : usrList) {
                out.println( "<form action='ControllerServlet' method='POST'>");
                out.println( "<tr>");
                out.println( "<td>"+ (count++) +"</td>");
                out.println( "<td>" + user.getUsername() 
                        + "<input type='hidden' name='pk' value='" 
                        + user.getUsername() + "' />"
                        + "</td>");
                out.println( "<td>"
                        + "<input type='text' name='txtPassword' value='"
                        + user.getPassword()
                        + "' />"
                        + "</td>");
                out.println( "<td>" 
                        + user.getLastname() 
                        + "</td>");
                
                if(user.isAdmin()) {
                    out.println( "<td>"
                                + "<input type='checkbox' name='chkAdmin' "
                                + "value='ADMIN'"
                                + " checked='checked' />"
                                + "</td>");
                } else {
                    out.println( "<td>"
                                + "<input type='checkbox' name='chkAdmin' "
                                + "value='ADMIN'"
                                + "  />"
                                + "</td>");
                }
                
                String searchValue = request.getParameter("txtSearchValue");
                // Resuource?name=value&...
                String urlRewriting = "ControllerServlet?btAction=del"
                                        + "&pk="+user.getUsername()
                                        + "&lastSearchValue=" 
                                        + searchValue;
                out.println( "<td><a href=\"" + urlRewriting
                        + "\">Delete</a></td>");
                
                out.println( "<td>"
                        + "<input type='submit' value='Update' "
                        + "name='btAction' />"
                        + "<input type='hidden' name='lastSearchValue' "
                        + "value='"
                        + searchValue
                        + "'/>"
                        + "</td>");
                
                out.println( "</tr>");
                
                out.println( "</form>");
            }
            
            out.println( "</tbody></table>");
        } catch (NullPointerException e) {
            e.printStackTrace();
            
        }
                     
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchResultServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Cookie[] cookies = request.getCookies();
            if(cookies!=null) {
                String usrName = cookies[cookies.length-1].getName();
                out.println("<font color=\"red\">Welcome, "
                        + usrName
                        + "</font>");
            }
            
            out.println("<h1>Search Result</h1>");
                        
            String searchValue = request.getParameter("txtSearchValue");
            out.println("Search Value: " + searchValue + "<br />");
            
           this.processPrintSearchResult
                                        (searchValue, request, out);
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
