/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lab5.Account.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lab5.Account.AccountDAO;
import com.lab5.Account.AccountDTO;
import com.lab5.Account.AccountError;

/**
 *
 * @author Hau
 */
public class LoginServlet extends HttpServlet {
    private final String loginPage = "index.jsp";
    private final String processLoginPage = "processLogin.jsp";
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
            AccountError erroObj = new AccountError();
            
            String txtUsername = request.getParameter("txtUsername");
            String txtPassword = request.getParameter("txtPassword");
            
            if(txtUsername==null) {
                erroObj.setUsernameFieldNull("Your request is invalid with this field.");
            } else if(txtUsername.equals("")) {
                erroObj.setUsernameFieldNull("Username Field cannot be null.");
            }
            
            if(txtPassword==null) {
                erroObj.setPasswordFieldNull("Your request is invalid with this field.");
            } else if(txtPassword.equals("")) {
                erroObj.setPasswordFieldNull("Password Field cannot be null.");
            }
            
            request.setAttribute("ERROROBJ", erroObj);
            
            if(erroObj.isRaisedError()) {
                RequestDispatcher dr = request.getRequestDispatcher(loginPage);
                dr.forward(request, response);
                return;
            }
            
            
            RequestDispatcher dr = request.getRequestDispatcher(processLoginPage);
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
