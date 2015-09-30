/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User.Servlets;

import User.UserInsertError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hau
 */
public class ShowInsertErrServlet extends HttpServlet {

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
            out.println("<title>Insert Error</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Errors occur in Insert Processing</h1>");
            UserInsertError errObj = (UserInsertError) 
                                            request.getAttribute("INSERTERR");
            out.println("<font color='red' >");
            if (errObj != null) {
                if (errObj.getUsernameLengthErr() != null) {
                    out.println(errObj.getUsernameLengthErr()+"<br />");
                }
                if (errObj.getPasswordLengthErr() != null) {
                    out.println(errObj.getPasswordLengthErr()+"<br />");
                }
                if (errObj.getConfirmNotMatch() != null) {
                    out.println(errObj.getConfirmNotMatch()+"<br />");
                }
                if (errObj.getLastnameLengthErr() != null) {
                    out.println(errObj.getLastnameLengthErr()+"<br />");
                }
                if (errObj.getUsernameExists() != null) {
                    out.println(errObj.getUsernameExists()+"<br />");
                }
            }
            out.println("</font>");
            
            out.println("</body>");
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
