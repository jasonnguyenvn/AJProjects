/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab8.sessions;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author Hau
 */
public interface UserSessionBeanRemoteHome extends EJBHome {
    com.lab8.sessions.UserSessionBeanRemote create() 
            throws CreateException, RemoteException;
}
