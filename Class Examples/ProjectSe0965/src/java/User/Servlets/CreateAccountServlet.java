package User.Servlets;

import User.UserDAO;
import User.UserInsertError;
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

/**
 *
 * @author Hau
 */
public class CreateAccountServlet extends HttpServlet {
    private final String errorPage = "Register.jsp";
    private final String loginPage = "login.html";
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
            String username = request.getParameter("txtUsername").trim();
            String password = request.getParameter("txtPassword").trim();
            String confirm = request.getParameter("txtConfirm").trim();
            String lastname = request.getParameter("txtFull").trim();
            Logger logger = Logger.getLogger(CreateAccountServlet.class.getName());
            boolean isErrs = false;
            UserInsertError errObj = new UserInsertError();
            if(username.length() < 6 || username.length() > 20 ) {
                isErrs = true;
                errObj.setUsernameLengthErr("Username phai tu 6 den 20 ky tu.");
                logger.log(Level.SEVERE, errObj.getUsernameLengthErr());
            }
            if(password.length() < 6 || password.length() > 30 ) {
                isErrs = true;
                errObj.setPasswordLengthErr("Password phai tu 6 den 30 ky tu.");
                logger.log(Level.SEVERE, errObj.getPasswordLengthErr());
            } else if (!confirm.equals(password)) {
                isErrs = true;
                errObj.setConfirmNotMatch("Confirm va password phai giong nhau.");
                logger.log(Level.SEVERE, errObj.getConfirmNotMatch());
            }
            if(lastname.length() < 2 || lastname.length() > 50 ) {
                isErrs = true;
                errObj.setLastnameLengthErr("Full name phai tu 2 den 50 ky tu.");
                logger.log(Level.SEVERE, errObj.getLastnameLengthErr());
            } 
            
            String url = errorPage;
            if(lastname.length() < 2 || lastname.length() > 50) {
                isErrs = true;
                request.setAttribute("INSERTERR", errObj);
            } else {
                UserDAO dao = new UserDAO();
                boolean result = false;
                try {
                    result = dao.insertAccount(username, password, 
                                        lastname, false);
                } catch (        SQLException | ClassNotFoundException ex) {
                    log(ex.getMessage());
                    
                }
                if (result) {
                    url = loginPage;
                } else {
                    errObj.setUsernameExists(username + " da ton tai trong he thong." );
                    request.setAttribute("INSERTERR", errObj
                    );
                }
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
