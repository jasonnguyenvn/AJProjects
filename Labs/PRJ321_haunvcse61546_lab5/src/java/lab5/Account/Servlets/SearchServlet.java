/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5.Account.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab5.Account.AccountDAO;
import lab5.Account.AccountDTO;
import lab5.Account.AccountError;

/**
 *
 * @author Hau
 */
public class SearchServlet extends HttpServlet {
    private final String viewPage = "view.jsp";
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
            String txtSearchValue = request.getParameter("txtSearchValue");
            
            AccountError erroObj = new AccountError();
            
            if(txtSearchValue==null) {
                erroObj.setSearchFieldNull("Your reqeust is invalid");
            } else if(txtSearchValue.equals("")) {
                erroObj.setSearchFieldNull("Lastname field cannot be null.");
            }
            
            if(erroObj.isRaisedError()) {
                request.setAttribute("ERROROBJ", erroObj);
            } else {
                
                List<AccountDTO> searchList = null;
                AccountDAO dao = new AccountDAO();

                try {
                    searchList = dao.searchByLastName(txtSearchValue);
                } catch (    ClassNotFoundException | SQLException ex) {
                    log(ex.getMessage());
                }

                if(searchList!=null) {
                    request.setAttribute("SEARCHLIST", searchList);
                }
            
            }
            
            
            RequestDispatcher dr = request.getRequestDispatcher(viewPage);
            dr.forward(request, response);
                    
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
