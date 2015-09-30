/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales;

/**
 *
 * @author Hau
 */
public class CartObjAddError {
    private String invalidProduct;
    private String productNotExisted;
    
    private boolean raisedError;

    public boolean isRaisedError() {
        return raisedError;
    }

    public void setRaisedError(boolean raisedError) {
        this.raisedError = raisedError;
    }
    
    

    public String getInvalidProduct() {
        return invalidProduct;
    }

    public void setInvalidProduct(String invalidProduct) {
        this.invalidProduct = invalidProduct;
        this.setRaisedError(true);
    }

    public String getProductNotExisted() {
        return productNotExisted;
    }

    public void setProductNotExisted(String productNotExisted) {
        this.productNotExisted = productNotExisted;
        this.setRaisedError(true);
    }
    
    
}
