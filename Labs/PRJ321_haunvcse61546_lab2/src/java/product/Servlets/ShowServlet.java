/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.Product;
import product.ProductDAO;

/**
 *
 * @author Hau
 */
public class ShowServlet extends HttpServlet {
    protected String processPrintProductList(Product[] proList) {
        String result = "";
        result += "";
        
        result += "<table border=\"1\">";
            
        result += "<thead align=\"left\">";
        result += "<tr>";
        result += " <th align=\"left\">Code</th>";
        result += "<th align=\"left\">Name</th>";
        result += " <th align=\"left\">Description</th>";
        result += "<th align=\"left\">Price</th>";
        result += "<th align=\"left\">Category</th>";
        result += "</tr></thead><tbody>";
        
        for(Product pro : proList) {
            result += "<tr>";
            result += "<td>"+pro.getCode()+"</td>";
            result += "<td>"+pro.getName()+"</td>";
            result += "<td><img style=\"max-width:300px;max-height:150px;\" "
                        + "src=\""+pro.getDescription()+"\" /></td>";
            result += "<td>"+pro.getPrice()+"</td>";
            result += "<td>"+pro.getCategory()+"</td>";
            result += "</tr>";
        }
        result += "</tbody></table>";  
        return result;
    }
    
    
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
            Product[] allPros = null;
            try {
                allPros = ProductDAO.getAllProducts();
            } catch (SQLException ex) {
                ex.printStackTrace();
                response.sendRedirect("databaseError.html");
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>All products</h1>");
            
            out.println(this.processPrintProductList(allPros));
            
            out.println("<br/><a href=\"index.html\">Homepage</a>");
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
