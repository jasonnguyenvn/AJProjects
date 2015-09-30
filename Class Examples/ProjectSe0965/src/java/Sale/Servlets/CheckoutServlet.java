/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sale.Servlets;

import Sale.CartObj;
import Sale.OrderDAO;
import Sale.OrderDTO;
import Sale.OrderItem;
import Sale.ProductDAO;
import Sale.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hau
 */
public class CheckoutServlet extends HttpServlet {
    private final String errorPage = "createOrderError.html";
    private final String cannotCreateOrderPage = "cantCreateOrder.html";
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
            HttpSession session = request.getSession();
            if(session==null) {
                out.println("ERROR");
                return;
            }
            CartObj cart = (CartObj) session.getAttribute("CART");
            if(cart==null) {
                out.println("ERROR");
                return;
            }
            HashMap<String, Integer> items = cart.getItems();
            if(items.size()<=0) {
                response.sendRedirect(cannotCreateOrderPage);
                return ;
            }

            OrderDTO order = new OrderDTO("GUEST CUSTOMER");
            
            try {
                // prepare items
                
                for (Map.Entry item : items.entrySet()) {
                    String title =  (String) item.getKey();
                    int quantity = (int) item.getValue();
                    
                    ProductDAO proDAO = new ProductDAO();
                    ProductDTO pro = proDAO.getProductByTitle(title);
                    float price = pro.getPrice();
                    OrderItem orItem = new OrderItem(title, price, quantity);
                    order.addItemToOrder(orItem);
                }
                OrderDAO dao = new OrderDAO();
                
                int orderID = dao.createNewOrder(order);
                if(orderID<0) {
                    response.sendRedirect(errorPage);
                    return;
                }
                
                session.removeAttribute("CART");
                
                response.sendRedirect(shoppingPage);
                
//                String urlRewriting = "ControllerServlet?btAction=view_order"
//                                        + "&pk="+orderID;
//                response.sendRedirect(urlRewriting);
                
                
            }  catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
