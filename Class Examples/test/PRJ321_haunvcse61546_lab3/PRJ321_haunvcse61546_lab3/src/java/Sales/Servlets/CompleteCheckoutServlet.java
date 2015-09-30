/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.Servlets;

import Sales.CartObj;
import Sales.OrderDAO;
import Sales.OrderDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hau
 */
public class CompleteCheckoutServlet extends HttpServlet {
    private final String showCheckoutResultServlet = "ShowCheckoutResultServlet";
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
            out.println("<title>Checkout</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession();
            if(session!=null) {
                CartObj cart = (CartObj) session.getAttribute("CART");
                if(cart!=null) {
                    String txtCustName = request.getParameter("txtCustName");
                    cart.setCustName(txtCustName);
                    
                    OrderDTO order = OrderDTO.parseOrderDTO(cart);
                    if(order==null) {
                        out.println("There is no product in your cart.");
                    } else {
                        try {
                            OrderDAO dao = new OrderDAO();
                            boolean check = dao.createOrder(order);
                            if(check==false)   {
                                log("COULD NOT INSERT NEW ORDER RECORD.");
                                response.sendError(response.SC_INTERNAL_SERVER_ERROR);
                            }
                         } catch (SQLException | ClassNotFoundException ex) {
                            log(ex.getMessage(), ex);
                            response.sendError(response.SC_INTERNAL_SERVER_ERROR);
                         }
                        
                        session.removeAttribute("CART");
                        String urlRewriting = "ControllerServlet?btAction=view_order"
                                            +"&pk="+order.getOrdID();
                        response.sendRedirect(urlRewriting);
                    }
                }
                
            }
            
            out.println("<h1>Your cart has not existed yet.</h1>");
            out.println("<h3><a href=\"ControllerServlet\">Click here to go home</a></h3>");
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
