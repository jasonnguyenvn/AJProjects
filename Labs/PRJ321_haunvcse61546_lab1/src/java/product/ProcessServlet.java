/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

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
public class ProcessServlet extends HttpServlet {
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String badRequest = "<h1>Bad request.</h1></body></html>";
            String btnSave = request.getParameter("btnSave");
            if(btnSave==null) {
                out.println(badRequest);
                return;
            }
            if(btnSave.equals("Save")==false) {
                out.println(badRequest);
                return;
            }
            
            float productPrice = 0.0f;
            String txtPrice = request.getParameter("txtPrice");
            try {
                productPrice = Float.parseFloat(txtPrice);
            } catch (NumberFormatException e) {
                out.println("<h1>ERROR: INVALID PRICE.</h1>");
                out.println("<a href=\"addProducts.html\">Click here to"
                        + " try again.</a><br />");
                out.println("</body></html>");
                return;
            }
            
            String txtCode = request.getParameter("txtCode");
            String txtName = request.getParameter("txtName");
            String txtDescription = request.getParameter("txtDescription");
            
            String cbCategory = request.getParameter("cbCategory");
            
            
            out.println("<h4>- The inputted product includes</h4>");
            out.println("+ Name: " + txtName + "<br />");
            out.println("+ Code: " + txtCode + "<br />");
            out.println("+ Category: " + cbCategory + "<br />");
            out.println("+ Description: " + txtDescription + " - Price: " 
                        + txtPrice + "<br />");
            
            out.println("<h4>- Home page</h4>");
            out.println("<a href=\"index.html\">Homepage</a>");
            
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
