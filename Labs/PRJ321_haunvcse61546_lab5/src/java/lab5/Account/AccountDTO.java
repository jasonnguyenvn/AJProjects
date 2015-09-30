/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5.Account;

import java.io.Serializable;

/**
 *
 * @author Hau
 */
public class AccountDTO implements Serializable {
    private String Username;
    private String Password;
    private String Lastname;
    private boolean isAdmin;

    public AccountDTO() {
    }

    public AccountDTO(String Username, String Password, String Lastname, boolean isAdmin) {
        this.Username = Username;
        this.Password = Password;
        this.Lastname = Lastname;
        this.isAdmin = isAdmin;
    }
    
    

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.Username != null ? this.Username.hashCode() : 0);
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
        if ((this.Username == null) ? (other.Username != null) : !this.Username.equals(other.Username)) {
            return false;
        }
        return true;
    }
    
    
    
}
