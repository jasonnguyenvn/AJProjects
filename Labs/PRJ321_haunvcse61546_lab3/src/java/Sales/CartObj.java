/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Hau
 */
public class CartObj implements Serializable {
    private String custName;
    private HashMap<ProductDTO, Integer> items;
    
    public CartObj() {
        this.custName = "00000";
        this.items = new HashMap<>();
    }

    public CartObj(String custName) {
        this.custName = custName;
        this.items = new HashMap<>();
    }
    

    public String getCustName() {
        return custName;
    }

    public HashMap<ProductDTO, Integer> getItems() {
        return items;
    }

    public void setCustName(String customerID) {
        this.custName = customerID;
    }
    
    public void addItemToCart(ProductDTO product) {
        int quantity = 1;
        if(items.containsKey(product)) {
            quantity = items.get(product) + 1;
        }
        
        items.put(product, quantity);
    }
    
    public void removeItemFromCart(ProductDTO product) {
        if(items.containsKey(product)) {
            items.remove(product);
        }
    }    
    
    
    
}

