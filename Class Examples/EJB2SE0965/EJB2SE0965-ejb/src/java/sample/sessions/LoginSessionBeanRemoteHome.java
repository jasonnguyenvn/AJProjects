/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sessions;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author Hau
 */
public interface LoginSessionBeanRemoteHome extends EJBHome {
     sample.sessions.LoginSessionBeanRemote create() throws CreateException, RemoteException;
}
