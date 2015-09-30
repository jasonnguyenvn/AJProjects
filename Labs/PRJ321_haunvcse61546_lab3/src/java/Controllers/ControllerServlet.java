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
    
    private final String onlineStoreServlet = "OnlineStoreServlet";
    private final String addToCartServlet = "AddToCartServlet";
    private final String viewCartServlet = "ViewCartServlet";
    private final String checkoutServlet = "CheckoutServlet";
    private final String completeCheckoutServlet = "CompleteCheckoutServlet";
    private final String viewOrderServlet = "ViewOrderServlet";

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
            String button = request.getParameter("btAction");
            
            String url = null;
            if(button==null) {
                url = onlineStoreServlet;
            } else {
                if(button.equals("Add to Cart")) {
                    url = addToCartServlet;
                } else if(button.equals("view_shopping_cart")) {
                    url = viewCartServlet;
                } else if(button.equals("checkout")) {
                    url = checkoutServlet;
                } else if(button.equals("Complete Order")) {
                    url = completeCheckoutServlet;
                } else if(button.equals("view_order")) {
                    url = viewOrderServlet;
                } else {
                    response.sendError(response.SC_NOT_FOUND);
                }
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
                                    
            
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
