/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Authenrization;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hau
 */
public class AuthServlet extends HttpServlet {
    private final String showErrorServlet = "ShowAuthErrorServlet";

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try {
                String name = request.getParameter("txtName");
                String role = request.getParameter("txtRole");
                
                String loggedName = request.getUserPrincipal().getName();
                AuthError errObj = new AuthError();
                if(name.equals(loggedName)==false) {
                    errObj.setInvalidUsername("Name was not equal logged user's name.");
                }
                
                if(request.isUserInRole(role)==false) {
                    errObj.setPermissionDenied("Your role do not same as logged user's role");
                } else if(role.equals("admin")==false) {
                    errObj.setPermissionDenied("You cannot access this place with your role.");
                }
                
                String url;
                if(errObj.isRaisedErrors()) {
                    url = showErrorServlet;
                    request.setAttribute("ERROROBJ", errObj);
                    RequestDispatcher dr = request.getRequestDispatcher(url);
                    dr.forward(request, response);
                    
                } else {
                    url = "AdminControllerServlet?btAction=adm_dashboard";
                    response.sendRedirect(url);
                    out.close();
                    return;
                }
                
            } catch (NullPointerException ex) {
                log("user try to acces auth place");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
