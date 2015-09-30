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
public class OrderDAO {
    
    public OrderDTO getOrderById(int ordID) 
            throws SQLException, ClassNotFoundException {
        OrderDTO result = null;
        Connection con;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        con = MSSQLUltil.openConnection();
        if(con==null)
            throw new SQLException("COULD NOT CONNECT TO DB.");
        
        String sql = "SELECT * FROM tbl_orders WHERE ordID=? ";
                
        try {
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, ordID);
            
            rs = stm.executeQuery();
            
            if(rs.next()) {
                String custName = rs.getString("custName");
                result = new OrderDTO(custName);
                result.setOrdID(ordID);
                
                OrderDetailDAO detailDAO = new OrderDetailDAO();
                ArrayList<OrderDetailDTO> itemList;
                itemList = detailDAO.getOrderDetailByOrdID(ordID);
                
                result.setItems(itemList);
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
    
    protected boolean insertOrderDetail(int ordID, ArrayList<OrderDetailDTO> items) 
            throws SQLException, ClassNotFoundException {
        OrderDetailDAO dao = new OrderDetailDAO();
        return dao.insertOrderDetailItems(ordID, items);
    }
    
    public boolean createOrder(OrderDTO order) 
            throws SQLException, ClassNotFoundException {
        Connection con;
        PreparedStatement stm = null;
        
        con = MSSQLUltil.openConnection();
        if(con==null)
            throw new SQLException("COULD NOT CONNECT TO DB.");
        
        String sql = "INSERT INTO tbl_orders(custName) VALUES (?) ";
                
        try {
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, order.getCustName());
            
            int resultCode = stm.executeUpdate();
            
            if(resultCode>0) {
                ResultSet rs = stm.getGeneratedKeys();
                if(rs.next()) {
                    int ordID = rs.getInt(1);
                    order.setOrdID(ordID);
                    boolean checkInsertDetail = this.insertOrderDetail(ordID, 
                                                    order.getItems());
                    if(checkInsertDetail==false) {
                        rs.close();
                        throw new SQLException("COULD NOT INSERT ORDER DETAIL.");
                    }
                }
                rs.close();
            } else {
                throw new SQLException("COULD NOT INSERT NEW ORDER RECORD.");
            }
            
        } finally {
            if(stm!=null)
                stm.close();
            con.close();
        }
        
        return true;
    }
    
    
}
