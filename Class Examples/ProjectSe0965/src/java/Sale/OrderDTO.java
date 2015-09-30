/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sale;

import java.util.ArrayList;

/**
 *
 * @author Hau
 */
public class OrderDTO {
    private int orderID;
    private String custLastName;
    private ArrayList<OrderItem> items;

    public OrderDTO() {
        orderID = -1;
        custLastName = "";
        items = new ArrayList<>();
    }

    public OrderDTO(String custLastName) {
        this.custLastName = custLastName;
        this.items =  new ArrayList<>();
    }

    public OrderDTO(int orderID, String custLastName) {
        this.orderID = orderID;
        this.custLastName = custLastName;
        this.items = new ArrayList<>();
    }
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.orderID;
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
        if (this.orderID != other.orderID) {
            return false;
        }
        return true;
    }
    
    
    public void addItemToOrder(OrderItem newItem) {
        if(this.items.contains(newItem))
            this.items.remove(newItem);
        
        this.items.add(newItem);
        
    }    
    
    
}
