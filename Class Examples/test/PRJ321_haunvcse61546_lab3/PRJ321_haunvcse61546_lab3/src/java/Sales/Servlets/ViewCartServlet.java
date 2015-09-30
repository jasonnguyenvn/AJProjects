/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.Servlets;

import Sales.CartObj;
import Sales.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hau
 */
public class ViewCartServlet extends HttpServlet {

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
            out.println("<title>View of your shopping cart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3 text-align='center'>Online Shop</h3>");
            out.println("<h1>View of your shopping cart</h1>");
            
            HttpSession session = request.getSession(false);
            if(session!=null) {
                CartObj cart = (CartObj) session.getAttribute("CART");
                if(cart!=null) {
                    HashMap<ProductDTO, Integer> items = cart.getItems();
                    Iterator<Entry<ProductDTO, Integer>> iterator =
                                                items.entrySet().iterator();
                    
                    out.println("<table border='1'>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>No</th>");
                    out.println("<th>Product ID</th>");
                    out.println("<th>Product Name</th>");
                    out.println("<th>Quantity per Unit</th>");
                    out.println("<th>Price</th>");
                    out.println("<th>Quantity</th>");
                    out.println("<th>Total</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    int count = 1;
                    float sumToatal = 0;
                    while(iterator.hasNext()) {
                        Entry<ProductDTO, Integer> entry = iterator.next();
                        ProductDTO item = entry.getKey();
                        int quantity = entry.getValue();
                        float total = item.getPrice() * quantity;
                        sumToatal += total;
                        out.println("<tr>");
                        out.println("<td>"
                                + (count++)
                                + "</td>");
                        out.println("<td>"
                                + item.getProID()
                                + "</td>");
                        String urlRewriting = "ControllerServlet?"
                                + "btAction=Add to Cart&pk=" + item.getProID();
                        out.println("<td><a href='"
                                + urlRewriting
                                + "' >"
                                + item.getProName()
                                + "</a></td>");
                        out.println("<td>"
                                + item.getQuanPerUnit()
                                + "</td>");
                        out.println("<td>"
                                + item.getPrice()
                                + "</td>");
                        
                        out.println("<td>"
                                +quantity
                                + "</td>");
                        out.println("<td>"
                                +total
                                + "</td>");

                        out.println("</tr>");
                    }
                    out.println("<tr>");
                    out.println("<td colspan='4'>Total: "
                            + (count-1)
                            + " products selected</td>");
                    out.println("<td colspan='2'>Payment in USD:</td>");
                    out.println("<td  >"
                            + sumToatal
                            + "</td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    
                    String urlRewriting = "ControllerServlet?btAction=checkout";
                    out.println("<h2><a href='"
                            + urlRewriting
                            + "'>Checkout</a></h2>");
                
                    out.println("</body></html>");
                    return;
                }
                
                
            }

            out.println("<h2>Your cart has not existed yet.</h2>");
            
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
