/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sesssions;

import java.util.HashMap;
import javax.ejb.Remote;

/**
 *
 * @author Hau
 */
@Remote
public interface CartSessionBeanRemote {
    public String getCustomerID();
    public HashMap<String, Integer> getItems();
    public void setCustomerID(String customerID);

    void addItemToCart(String title);

    void removeItemFromCart(String title);
}
