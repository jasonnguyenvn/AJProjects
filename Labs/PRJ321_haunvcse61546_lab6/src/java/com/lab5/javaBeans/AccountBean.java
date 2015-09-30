/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lab5.javaBeans;

import com.lab5.Account.AccountDAO;
import com.lab5.Account.AccountDTO;
import java.sql.SQLException;
import java.util.Objects;
import javax.naming.NamingException;

/**
 *
 * @author Hau
 */
public class AccountBean {
    private String username;
    private String password;
    private String lastname;
    private boolean role;

    public AccountBean() {
        this.username = "";
        this.password = "";
        this.lastname = "";
        this.role = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String Lastname) {
        this.lastname = Lastname;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean Role) {
        this.role = Role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountBean other = (AccountBean) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccountBean{" + "Username=" + username + '}';
    }

    public boolean checkLogin() throws NamingException, SQLException {
        AccountDAO dao = new AccountDAO();
        
        AccountDTO dto = dao.checkLogin(username, password);
        if(dto == null) {
            return false;
        }
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.lastname = dto.getLastname();
        this.role = dto.isRole();
        return true;
    }
    
    
    public void getInfo()
            throws  SQLException, NamingException {
        AccountDAO dao = new AccountDAO();
        
        AccountDTO dto = dao.getUserByUsername(username);
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.lastname = dto.getLastname();
        this.role = dto.isRole();
                
    }
    
    
    

}
