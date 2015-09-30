/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package product;

import DBUtils.MSSQLUtil;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Hau
 */
public class ProductDAO {
    public static boolean saveProduct(Product newProduct) throws SQLException {
        boolean result = false;
        Connection conn = null;
        try {
            conn = MSSQLUtil.openConnection();
            result = newProduct.save(conn);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null)
                conn.close();
        }
        
        return result;
    }
    
    public static Product[] getAllProducts() throws SQLException {
        Product[] result = null;
        Connection conn = null;
        try {
            conn = MSSQLUtil.openConnection();
            result = Product.loadAll(conn);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null)
                conn.close();
        }
        
        return result;
    }
}
