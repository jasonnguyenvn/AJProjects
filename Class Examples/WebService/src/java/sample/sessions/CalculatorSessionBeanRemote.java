/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sessions;

import javax.ejb.Remote;

/**
 *
 * @author Hau
 */
@Remote
public interface CalculatorSessionBeanRemote {

    double add(double num1, double num2);

    double subtract(double num1, double num2);
    
}
