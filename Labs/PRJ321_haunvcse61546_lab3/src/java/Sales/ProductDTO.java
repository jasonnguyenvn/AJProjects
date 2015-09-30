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
public class ProductDTO implements Serializable {
    private int proID;
    private String proName;
    private String quanPerUnit;
    private float price;

    public ProductDTO() {
    }

    public ProductDTO(int proID, String proName, String quanPerUnit, float price) {
        this.proID = proID;
        this.proName = proName;
        this.quanPerUnit = quanPerUnit;
        this.price = price;
    }
    
    

    public ProductDTO(String proName, String quanPerUnit, float price) {
        this.proName = proName;
        this.quanPerUnit = quanPerUnit;
        this.price = price;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getQuanPerUnit() {
        return quanPerUnit;
    }

    public void setQuanPerUnit(String quanPerUnit) {
        this.quanPerUnit = quanPerUnit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.proID;
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
        final ProductDTO other = (ProductDTO) obj;
        return this.proID == other.proID;
    }
    
    
    
}
