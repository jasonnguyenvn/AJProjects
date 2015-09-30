/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author Hau
 */
public class OrderDTO implements Serializable  {
    private int ordID;
    private String custName;
    private ArrayList<OrderDetailDTO> items;
    
    
    public OrderDTO() {
        custName = "GUEST";
        items = new ArrayList<OrderDetailDTO>();
        ordID = -1;
    }

    public OrderDTO(String custName) {
        this.custName = custName;
        items = new ArrayList<OrderDetailDTO>();
        ordID = -1;
    }
    
    public void addItemToOrder(OrderDetailDTO order) {
        if(items.contains(order)) {
            OrderDetailDTO current = items.get(items.indexOf(order));
            int quantity = current.getQuantity() + order.getQuantity();
            current.setQuantity(quantity);
        } else {
            items.add(order);
        }
    }

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public ArrayList<OrderDetailDTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderDetailDTO> items) {
        this.items = items;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.ordID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDTO other = (OrderDTO) obj;
        if (this.ordID != other.ordID) {
            return false;
        }
        return true;
    }
    
    public static OrderDTO parseOrderDTO(CartObj cart) {
        OrderDTO result = new OrderDTO(cart.getCustName());
        
        Iterator<Entry<ProductDTO, Integer>> iterator;
        iterator = cart.getItems().entrySet().iterator();
        
        while(iterator.hasNext()) {
            Entry<ProductDTO, Integer> entry = iterator.next();
            ProductDTO product = entry.getKey();
            int quantity = entry.getValue();
            
            OrderDetailDTO detailItem = new OrderDetailDTO(product, 
                                                product.getPrice(), quantity);
            result.addItemToOrder(detailItem);
        }
        
        if(result.getItems().size()<=0) {
            return null;
        }
        
        return result;
    }
    
}
