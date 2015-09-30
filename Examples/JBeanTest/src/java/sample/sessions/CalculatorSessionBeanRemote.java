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
public interface CalculatorSessionBeanRemote extends EJBObject{

    double add(double var1, double var2) throws RemoteException;

    double substract(double var1, double var2) throws RemoteException;
    
}
