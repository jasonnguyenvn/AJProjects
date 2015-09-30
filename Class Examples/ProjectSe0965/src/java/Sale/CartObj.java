/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sale;

import java.util.HashMap;

/**
 *
 * @author Hau
 */
public class CartObj {
    private String customerID;
    private HashMap<String, Integer> items;
    
    public CartObj() {
        this.customerID = "00000";
        this.items = new HashMap<>();
    }

    public CartObj(String customerID) {
        this.customerID = customerID;
        this.items = new HashMap<>();
    }
    

    public String getCustomerID() {
        return customerID;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    public void addItemToCart(String title) {
        int quantity = 1;
        if(items.containsKey(title)) {
            quantity = items.get(title) + 1;
        }
        
        items.put(title, quantity);
    }
    
    public void removeItemFromCart(String title) {
        if(items.containsKey(title)) {
            items.remove(title);
        }
    }    
    
}
