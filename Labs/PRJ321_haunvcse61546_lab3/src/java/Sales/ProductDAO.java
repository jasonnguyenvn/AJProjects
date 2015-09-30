/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales;

import DBUltils.MSSQLUltil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hau
 */
public class ProductDAO {
    
    public ProductDTO getProductByID(int proID)
            throws SQLException, ClassNotFoundException {
        ProductDTO resultObj = null;
        Connection con = MSSQLUltil.openConnection();
        if(con==null)
            throw new SQLException("Could not connect to DB.");
        
        PreparedStatement stm = null;
        ResultSet result = null;
        
        String sql = "SELECT * FROM tbl_products WHERE proID=? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setInt(1, proID);
            
            result = stm.executeQuery();
            if(result.next()) {
                String proName = result.getString("proName");
                String quanPerUnit = result.getString("quanPerUnit");
                float price = result.getFloat("price");
                resultObj = new ProductDTO(proID, proName, quanPerUnit, price);
            }
            
        } finally {
            if(stm!=null)
                stm.close();
            if(result!=null)
                result.close();
            con.close();
        }
        
        return resultObj; 
    }
    
    public ArrayList<ProductDTO> getAllProducts() 
            throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
        Connection con = MSSQLUltil.openConnection();
        if(con==null)
            throw new SQLException("Could not connect to DB.");
        
        PreparedStatement stm = null;
        ResultSet result = null;
        
        String sql = "SELECT * FROM tbl_products ";
        
        try {
            stm = con.prepareCall(sql);
            
            result = stm.executeQuery();
            while(result.next()) {
                int proID = result.getInt("proID");
                String proName = result.getString("proName");
                String quanPerUnit = result.getString("quanPerUnit");
                float price = result.getFloat("price");
                ProductDTO product = new ProductDTO(proID, proName, 
                                                    quanPerUnit, price);
                list.add(product);
            }
            
        } finally {
            if(stm!=null)
                stm.close();
            if(result!=null)
                result.close();
            con.close();
        }
        
        return list;        
    }
    
}
