/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sessions;

import javax.ejb.Stateless;

/**
 *
 * @author Hau
 */
@Stateless
public class CalculatorSessionBean implements CalculatorSessionBeanLocal, CalculatorSessionBeanRemote {

    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    
}
