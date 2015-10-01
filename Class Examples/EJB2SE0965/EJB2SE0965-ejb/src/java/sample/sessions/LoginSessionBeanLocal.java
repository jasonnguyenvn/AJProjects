/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sessions;

import javax.ejb.EJBLocalObject;

/**
 *
 * @author Hau
 */
public interface LoginSessionBeanLocal extends EJBLocalObject {

    boolean checkLogin(String username, String password);
    
}
