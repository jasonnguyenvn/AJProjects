/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lab5.Account;

import java.io.Serializable;

/**
 *
 * @author Hau
 */
public class AccountDTO implements Serializable {
    private String username;
    private String password;
    private String lastname;
    private boolean role;

    public AccountDTO() {
    }

    public AccountDTO(String Username, String Password, String Lastname, boolean role) {
        this.username = Username;
        this.password = Password;
        this.lastname = Lastname;
        this.role = role;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
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

    public boolean isAdmin() {
        return role;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.role = isAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.username != null ? this.username.hashCode() : 0);
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
        final AccountDTO other = (AccountDTO) obj;
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        return true;
    }
    
    
    
}
