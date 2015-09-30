/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sale.Servlets;

import Sale.OrderDAO;
import Sale.OrderDTO;
import Sale.OrderItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hau
 */
public class ViewOrderServlet extends HttpServlet {
    private final String shoppingPage = "shoppingCart.html";
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
            out.println("<title>View Order</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>View Order</h1>");
            try {
                String pk = request.getParameter("pk");
                int orderID = Integer.parseInt(pk);
                OrderDAO dao = new OrderDAO();
                OrderDTO order = dao.getOrderByID(orderID);
                out.println("Customer Last Name: "+order.getCustLastName()+"<br/>");
                out.println("Your order detail:<br/>");
                out.println( "<table border=\"1\" >");
                out.println( "<thead>");
                out.println( "<tr>");
                out.println( "<th>No.</th>");
                out.println( "<th>Title</th>");
                out.println( "<th>Price</th>");
                out.println( "<th>Quantity</th>");
                out.println( "<th>Total</th>");
                out.println( "</tr>");
                out.println( "</thead>");
                out.println("<tbody>");
                
                int count = 1;
                float total = 0;
                for(OrderItem item : order.getItems()) {
                    out.println( "<tr>");
                    out.println( "<td>"
                                + (count++)
                                + "</td>");
                    out.println( "<td>"
                                + item.getTitle()
                                + "</td>");
                    out.println( "<td>"
                                + item.getPrice()
                                + "</td>");
                    out.println( "<td>"
                                + item.getQuantity()
                                + "</td>");
                    float tmpTotal = item.getPrice() * item.getQuantity();
                    total += tmpTotal;
                    out.println( "<td>"
                                + tmpTotal
                                + "</td>");
                    out.println( "</tr>");
                }
                
                out.println("<tr>");
                out.println("<td colspan='4'>"
                        + "TOTAL PRICE OF ALL ITEMS"
                        + "</td>");
                out.println("<td>"
                        + total
                        + "</td>");
                out.println("</tr>");
                out.println("</tbody></table>");
                out.println("<h2><a href='"
                        + shoppingPage
                        + "'>Click here to continue shopping</a></h2>");
                
            } catch (NumberFormatException numEx) {
                response.sendError(response.SC_BAD_REQUEST, "BAD REQUEST");
            } catch (    SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ViewOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
