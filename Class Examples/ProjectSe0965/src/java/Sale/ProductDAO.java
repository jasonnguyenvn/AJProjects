/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sale;

import DBUtils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hau
 */
public class ProductDAO {
    public ProductDTO getProductByTitle(String title) 
        throws SQLException, ClassNotFoundException {
        Connection con ;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO pro = null;
        
        con = DBUtil.makeConnection();
        if(con==null) {
            throw new SQLException("Could not connect to DB.");
        }
        
        String sql = "SELECT * FROM tbl_products WHERE title=? ";
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, title);
            
            rs = stm.executeQuery();
            if(rs.next()) {
                float price = rs.getFloat("price");
                pro = new ProductDTO(title, price);
            }
            
        } finally {
            if(rs != null)
                rs.close();
            if(stm!=null) 
                stm.close();
            con.close();
        }
        
       return pro;
    }
}
