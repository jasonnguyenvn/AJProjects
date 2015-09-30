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
public interface CalculatorSessionBeanLocal extends EJBLocalObject {

    double add(double var1, double var2);

    double substract(double var1, double var2);
    
}
