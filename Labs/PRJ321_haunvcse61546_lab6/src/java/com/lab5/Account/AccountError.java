/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lab5.Account;

/**
 *
 * @author Hau
 */
public class AccountError {
    boolean raisedError;
    
    private String usernameOrPasswordIncorrect;
    private String searchFieldNull;
    private String usernameFieldNull;
    private String passwordFieldNull;

    public AccountError() {
        raisedError = false;
    }

    public boolean isRaisedError() {
        return raisedError;
    }

    public void setRaisedError(boolean raisedError) {
        this.raisedError = raisedError;
    }

    public String getSearchFieldNull() {
        return searchFieldNull;
    }

    public void setSearchFieldNull(String searchFieldNull) {
        this.searchFieldNull = searchFieldNull;
        this.setRaisedError(true);
    }
    
    

    public String getUsernameOrPasswordIncorrect() {
        return usernameOrPasswordIncorrect;
    }

    public void setUsernameOrPasswordIncorrect(String usernameOrPasswordIncorrect) {
        this.usernameOrPasswordIncorrect = usernameOrPasswordIncorrect;
        this.setRaisedError(true);
    }

    public String getUsernameFieldNull() {
        return usernameFieldNull;
    }

    public void setUsernameFieldNull(String usernameFieldNull) {
        this.usernameFieldNull = usernameFieldNull;
        this.setRaisedError(true);
    }

    public String getPasswordFieldNull() {
        return passwordFieldNull;
    }

    public void setPasswordFieldNull(String passwordFieldNull) {
        this.passwordFieldNull = passwordFieldNull;
        this.setRaisedError(true);
    }

    
    
    
    
    
    
}
