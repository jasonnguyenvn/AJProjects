/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sessions;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author Hau
 */
public interface LoginSessionBeanLocalHome extends EJBLocalHome {
    
    sample.sessions.LoginSessionBeanLocal create() throws CreateException;
}
