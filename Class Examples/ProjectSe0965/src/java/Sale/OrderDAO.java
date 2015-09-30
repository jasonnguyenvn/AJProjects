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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hau
 */
public class OrderDAO {
    public OrderDTO getOrderByID(int orderID)
            throws SQLException, ClassNotFoundException {
        OrderDTO result = null;
        Connection conn ;
        PreparedStatement stmGetOrder = null;
        PreparedStatement stmGetOrderDetail = null;
        
        conn = DBUtil.makeConnection();
        if (conn == null) {
            throw new SQLException("CANNOT CONNECT TO DB.");
        }
        String getOrderSQL = "SELECT * FROM tbl_orders WHERE orderID=? ";
        String getOrderDetailSQL = "SELECT * FROM tbl_order_detail "
                                    + " WHERE orderID=? ";
        
        try {
            stmGetOrder = conn.prepareStatement(getOrderSQL);
            stmGetOrder.setString(1, orderID+"");
            ResultSet orderInfo = stmGetOrder.executeQuery();
            
            if(orderInfo.next()) {
                String custLastName = orderInfo.getString("custLastName");
                result = new OrderDTO(orderID, custLastName);
                
                stmGetOrderDetail = conn.prepareStatement(getOrderDetailSQL);
                stmGetOrderDetail.setString(1, orderID+"");
                ResultSet orderItems = stmGetOrderDetail.executeQuery();
                while(orderItems.next()) {
                    String tilte = orderItems.getString("title");
                    float price = orderItems.getFloat("price");
                    int quantity = orderItems.getInt("quantity");
                    OrderItem item = new OrderItem(orderID, tilte, price, quantity);
                    result.addItemToOrder(item);
                }
            }
        } finally {
            if (stmGetOrder != null)
                stmGetOrder.close();
            if (stmGetOrderDetail != null)
                stmGetOrderDetail.close();
            conn.close();
        }
        
        return result;
    }
    
    public int createNewOrder(OrderDTO order)
            throws SQLException, ClassNotFoundException {
        int result = -1;
        Connection conn ;
        PreparedStatement stmOrder = null;
        
        conn = DBUtil.makeConnection();
        if(conn == null)
            throw new SQLException("CANNOT CONNECT TO DB.");
        String sqlInsertOrder = "INSERT INTO tbl_orders VALUES(?)";
        
        try {
            stmOrder = conn.prepareStatement(sqlInsertOrder, 
                                             Statement.RETURN_GENERATED_KEYS);
            stmOrder.setString(1, order.getCustLastName() );
            int checkExcute = stmOrder.executeUpdate();
            if(checkExcute>0) {
                ResultSet orderRs = stmOrder.getGeneratedKeys();
                if(orderRs.next()) {
                    int orderID = orderRs.getInt(1);
                    boolean check = this.addItemsToOrder(orderID, order.getItems(), conn);
                    if(check)
                        result = orderID;
                }        
            }
            
        } finally {
            if(stmOrder!=null)
                stmOrder.close();
            conn.close();
        }
        
        return result;
    }
    
    protected boolean addItemsToOrder(int orderID, ArrayList<OrderItem> itemList,
         Connection conn) throws SQLException {
        String sql = "INSERT INTO tbl_order_detail VALUES  (?, ?, ?, ?) ";
        for(OrderItem item : itemList) {
            PreparedStatement stm = null; 
            try {
                 stm = conn.prepareStatement(sql);
                 stm.setString(1, orderID+"");
                 stm.setString(2, item.getTitle());
                 stm.setString(3, item.getPrice()+"");
                 stm.setString(4, item.getQuantity()+"");
                 
                 int result = stm.executeUpdate();
                 if(result<=0) {
                     stm.close();
                     return false;
                 }
                 item.setOrderID(orderID);
            } finally {
                if(stm!=null) 
                    stm.close();
            }       
        }
        
        return true;
    } 
}
