/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.javabeans;

import sample.User.UserDAO;
import java.sql.SQLException;

/**
 *
 * @author Hau
 */
public class LoginBean {
    private String username;
    private String password;

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public boolean checkLogin() throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();
        boolean result = dao.checkLogin(username, password);
        
        return result;
    }
    
    
}
