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
public interface CalculatorSessionBeanLocalHome extends EJBLocalHome {
    
    sample.sessions.CalculatorSessionBeanLocal create() throws CreateException;
}
