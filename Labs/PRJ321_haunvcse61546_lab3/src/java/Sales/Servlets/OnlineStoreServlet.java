/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.Servlets;

import Sales.ProductDAO;
import Sales.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hau
 */
public class OnlineStoreServlet extends HttpServlet {
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
            out.println("<title>Online Store</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Online Store</h1>");
            out.println("<h2>Product List</h2>");
            ProductDAO dao = new ProductDAO();
            
            out.println("");
            
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>No</th>");
            out.println("<th>Product ID</th>");
            out.println("<th>Product Name</th>");
            out.println("<th>Quantity per Unit</th>");
            out.println("<th>Price</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            int count = 1;
            try {
                ArrayList<ProductDTO> list = dao.getAllProducts();
                
                for(ProductDTO item : list) {
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
                    
                    out.println("</tr>");
                }
            } catch (    SQLException | ClassNotFoundException ex) {
                log(ex.getMessage(), ex);
                response.sendError(response.SC_INTERNAL_SERVER_ERROR);
            }
            
            out.println("</tbody>");
            out.println("</table>");
            out.println("<h3>Total: "+(count-1)+" products in the store.</h3>");
            
            String urlRewriting = "ControllerServlet?btAction=view_shopping_cart";
            out.println("<h3><a href='"
                    + urlRewriting
                    + "'>View my shopping cart</a></h3>");
            
            
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
