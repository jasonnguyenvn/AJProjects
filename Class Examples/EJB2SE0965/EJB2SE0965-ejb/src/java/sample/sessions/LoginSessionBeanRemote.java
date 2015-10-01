/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sessions;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author Hau
 */
public interface LoginSessionBeanRemote extends EJBObject {

    boolean checkLogin(String username, String password) throws RemoteException;
    
}
