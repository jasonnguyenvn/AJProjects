/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sesssions;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 *
 * @author Hau
 */
@Stateful
public class CartSessionBean implements CartSessionBeanLocal, CartSessionBeanRemote {
    private String customerID;
    private HashMap<String, Integer> items;
    
    @PostConstruct
    public void initCart() {
        this.items = new HashMap<String, Integer>();
        this.customerID = "0000";
    }

    public void setCustomerID(String cusomerID) {
        this.customerID = cusomerID;
    }
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String getCustomerID() {
        return customerID;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    @Override
    public void addItemToCart(String title) {
        int quantity = 1;
        if(items.containsKey(title)) {
            quantity = items.get(title) + 1;
        }
        
        items.put(title, quantity);
    }

    @Override
    public void removeItemFromCart(String title) {
        if(items.containsKey(title)) {
            items.remove(title);
        }
    }
    
    
    
}
