/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.sessions.LoginSessionBeanRemote;
import sample.sessions.LoginSessionBeanRemoteHome;

/**
 *
 * @author Hau
 */
public class LoginServlet extends HttpServlet {
    private final String invalidPage = "invalid.html";
    private final String welcomePage = "welcome.jsp";
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            
            
            try {
                Context context = new InitialContext();
                Object obj = context.lookup("LoginJNDI");
                LoginSessionBeanRemoteHome homeObj = (LoginSessionBeanRemoteHome)
                        PortableRemoteObject.narrow(obj, LoginSessionBeanRemoteHome.class);
                
                LoginSessionBeanRemote ejbObj = homeObj.create();
                
                boolean result = ejbObj.checkLogin(username, password);
                
                String url = invalidPage;
                if (result == true) {
                    url = welcomePage;
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", username);
                }
                
                response.sendRedirect(url);
                
                
            }  catch (CreateException ex) {
                  log(ex.getMessage());
            } catch (RemoteException ex) {
                log(ex.getMessage());
            } catch (NamingException ex) {
                log(ex.getMessage());
            }
            
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
