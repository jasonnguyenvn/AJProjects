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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hau
 */
public class OrderDetailDAO {
    
    public ArrayList<OrderDetailDTO> getOrderDetailByOrdID(int ordID) 
            throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetailDTO> result = new ArrayList<>();
        Connection con;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        con = MSSQLUltil.openConnection();
        if(con==null)
            throw new SQLException("COULD NOT CONNECT TO DB.");
        
        String sql = "SELECT * FROM tbl_order_detail WHERE ordID=? ";
                
        try {
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, ordID);
            
            rs = stm.executeQuery();
            
            ProductDAO proDAO = new ProductDAO();
            while(rs.next()) {
                int proID = rs.getInt("proID");
                ProductDTO product = proDAO.getProductByID(proID);
                
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                
                OrderDetailDTO item = new OrderDetailDTO(ordID, product, price, 
                                        quantity);
                result.add(item);
            }
            rs.close();
            
        } finally {
            if(rs!=null)
                rs.close();
            if(stm!=null)
                stm.close();
            con.close();
        }
        
        return result;
    }
    
    public boolean insertOrderDetailItems(int ordID, ArrayList<OrderDetailDTO> items) 
            throws SQLException, ClassNotFoundException {
        
        Connection con;
        PreparedStatement stm = null;
        
        con = MSSQLUltil.openConnection();
        if(con==null)
            throw new SQLException("COULD NOT CONNECT TO DB.");
        
        String sql = "INSERT INTO tbl_order_detail(ordID, proID, price, "
                + " quantity) VALUES (?, ?, ?, ?) ";
                
        try {
            
            for(OrderDetailDTO item : items) {
                stm = con.prepareCall(sql);
                stm.setInt(1, ordID);
                stm.setInt(2, item.getProductData().getProID());
                stm.setFloat(3, item.getPrice());
                stm.setInt(4, item.getQuantity());
                
                int result = stm.executeUpdate();
                if(result<=0) {
                    stm.close();
                    con.close();
                    return false;
                }
            }
            
            
        } finally {
            if(stm!=null)
                stm.close();
            con.close();
        }
        
        return true;
    }
    
}
