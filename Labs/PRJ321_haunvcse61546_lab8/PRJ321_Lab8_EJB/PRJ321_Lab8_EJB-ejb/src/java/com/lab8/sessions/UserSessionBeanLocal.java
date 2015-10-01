/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab8.sessions;

import java.sql.SQLException;
import javax.ejb.EJBLocalObject;

/**
 *
 * @author Hau
 */
public interface UserSessionBeanLocal extends EJBLocalObject {

    boolean checkLogin(String username, String password) throws SQLException;
    
}
