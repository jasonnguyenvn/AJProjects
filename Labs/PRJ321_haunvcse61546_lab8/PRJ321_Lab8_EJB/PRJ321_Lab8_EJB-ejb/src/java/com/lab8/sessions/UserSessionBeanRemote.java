/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab8.sessions;

import java.rmi.RemoteException;
import java.sql.SQLException;
import javax.ejb.EJBObject;

/**
 *
 * @author Hau
 */
public interface UserSessionBeanRemote extends EJBObject {

    boolean checkLogin(String username, String password) 
            throws RemoteException, SQLException;
    
}
