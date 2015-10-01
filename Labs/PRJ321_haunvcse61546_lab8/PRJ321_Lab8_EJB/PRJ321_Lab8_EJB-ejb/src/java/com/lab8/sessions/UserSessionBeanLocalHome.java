/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab8.sessions;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author Hau
 */
public interface UserSessionBeanLocalHome extends EJBLocalHome {
    
    com.lab8.sessions.UserSessionBeanLocal create() throws CreateException;
}
