/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

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
public class ControllerServlet extends HttpServlet {
    final String LoginServlet = "LoginServlet";
    final String SearchServlet = "SearchServlet";
    final String deleteServlet = "deleteServlet";
    final String UpdateServlet = "UpdateServlet";
    final String nullServlet = "NullServlet";
    final String addItemServlet = "AddItemServlet";
    final String viewCartServlet = "ViewCartServlet";
    final String removeItemServlet = "RemoveItemServlet";
    final String checkoutServlet = "CheckoutServlet";
    final String viewOrderServlet = "ViewOrderServlet";
    final String createAccountServlet = "CreateAccountServlet";
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
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String button = request.getParameter("btAction");
            
            if(button == null) {
                RequestDispatcher rd = request.getRequestDispatcher(nullServlet);
                rd.forward(request, response);
                return;
            }
            
            String url = "";
            if(button.equals("Login")) 
                url = LoginServlet;
            else if (button.equals("Search"))
                url = SearchServlet;
            else if (button.equals("del"))
                url = deleteServlet;
            else if (button.equals("Update"))
                url = UpdateServlet;
            else if (button.equals("Add Book To your Cart"))
                url = addItemServlet;
            else if (button.equals("View Your Cart"))
                url = viewCartServlet;
            else if (button.equals("Remove Items"))
                url = removeItemServlet;
            else if (button.equals("Checkout"))
                url = checkoutServlet;
            else if (button.equals("view_order")) 
                url = viewOrderServlet;
            else if (button.equals("Create New Account"))
                url = createAccountServlet;
            else 
               out.println("Bad Request");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
                        
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