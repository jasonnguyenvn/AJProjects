/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales;

import java.io.Serializable;

/**
 *
 * @author Hau
 */
public class OrderDetailDTO  implements Serializable {
    private int ordID;
    private ProductDTO productData;
    private float price;
    private int quantity;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(ProductDTO productData, float price, int quantity) {
        this.productData = productData;
        this.price = price;
        this.quantity = quantity;
    }

    
    
    public OrderDetailDTO(int ordID, ProductDTO productData, float price, int quantity) {
        this.ordID = ordID;
        this.productData = productData;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public ProductDTO getProductData() {
        return productData;
    }

    public void setProductData(ProductDTO productData) {
        this.productData = productData;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.ordID;
        hash = 23 * hash + (this.productData != null ? this.productData.hashCode() : 0);
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
        final OrderDetailDTO other = (OrderDetailDTO) obj;
        if (this.ordID != other.ordID) {
            return false;
        }
        return this.productData == other.productData 
                || (this.productData != null && this.productData.equals(other.productData));
    }
    
    
    
    
    
    
}
