/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Authenrization;

/**
 *
 * @author Hau
 */
public class AuthError {
    private String invalidUsername;
    private String permissionDenied;
    
    private boolean raisedErrors;

    public AuthError() {
        raisedErrors = false;
        invalidUsername = null;
        permissionDenied = null;
    }
    
    

    public boolean isRaisedErrors() {
        return raisedErrors;
    }

    public void setRaisedErrors(boolean raisedErrors) {
        this.raisedErrors = raisedErrors;
    }
    
    

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public void setInvalidUsername(String invalidUsername) {
        this.invalidUsername = invalidUsername;
        this.raisedErrors = true;
    }

    public String getPermissionDenied() {
        return permissionDenied;
    }

    public void setPermissionDenied(String permissionDenied) {
        this.permissionDenied = permissionDenied;
        this.raisedErrors = true;
    }
    
    
}
