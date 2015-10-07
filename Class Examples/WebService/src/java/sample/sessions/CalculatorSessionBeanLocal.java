/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sessions;

import javax.ejb.Local;

/**
 *
 * @author Hau
 */
@Local
public interface CalculatorSessionBeanLocal {

    double add(double num1, double num2);

    double subtract(double num1, double num2);
    
}
