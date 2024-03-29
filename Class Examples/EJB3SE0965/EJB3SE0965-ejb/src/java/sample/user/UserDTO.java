/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Hau
 */
public class UserDTO implements  Serializable {
    
    private String username;
    private String password;
    private String lastname;
    private boolean roles;

    public boolean isRoles() {
        return roles;
    }

    public void setRoles(boolean roles) {
        this.roles = roles;
    }
    
    
    
    public UserDTO() { }
    
    public UserDTO(String username, String password, String lastname, 
            boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.roles = isAdmin;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isAdmin() {
        return roles;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.roles = isAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.username);
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
        final UserDTO other = (UserDTO) obj;
        return Objects.equals(this.username, other.username);
    }
    
}
