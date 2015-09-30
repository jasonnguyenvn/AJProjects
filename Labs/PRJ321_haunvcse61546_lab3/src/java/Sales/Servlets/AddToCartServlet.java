/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.Servlets;

import Sales.CartObj;
import Sales.CartObjAddError;
import Sales.ProductDAO;
import Sales.ProductDTO;
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
public class AddToCartServlet extends HttpServlet {
    private final String showAddToCartErrorPage = "AddToCartErrServlet";
    
    private final String onlineStoreServlet = "ControllerServlet";
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
            CartObj cart = (CartObj) session.getAttribute("CART");
            if(cart == null) {
                cart = new CartObj();
            }
            int proID = -1;
            String pk = request.getParameter("pk");
            CartObjAddError errObj = new CartObjAddError();
            String url = onlineStoreServlet;
            try {
                proID = Integer.parseInt(pk);
            } catch (NumberFormatException ex) {
                log(ex.getMessage(), ex);
                errObj.setInvalidProduct("ERROR: Your product is not valid.");
                url = showAddToCartErrorPage;
            }
            
            if(proID<0) {
                log("USER HAS INPUT PRODUCT ID < 0");
                errObj.setInvalidProduct("ERROR: Your product is not valid.");
                url = showAddToCartErrorPage;
            }
            
            try {
                ProductDAO dao = new ProductDAO();
                ProductDTO product = dao.getProductByID(proID);
                if(product==null) {
                    log("USER HAS INPUT PRODUCT ID THAT NOT HOLD A PRODUCT RECORD");
                    errObj.setProductNotExisted("SORRY, But your product did not exist.");
                    url = showAddToCartErrorPage;
                }
                
                cart.addItemToCart(product);
            } catch (    SQLException | ClassNotFoundException ex) {
                log(ex.getMessage(), ex);
                response.sendError(response.SC_INTERNAL_SERVER_ERROR);
            }
            
            session.setAttribute("CART", cart);
            
            if(errObj.isRaisedError()==false) {
                response.sendRedirect(url);
            } else {
                request.setAttribute("ADDCARTERR", errObj);
                
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
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
