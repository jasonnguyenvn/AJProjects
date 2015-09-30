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
public interface CalculatorSessionBeanRemoteHome extends EJBHome {
    sample.sessions.CalculatorSessionBeanRemote create() 
            throws CreateException, RemoteException;
}
