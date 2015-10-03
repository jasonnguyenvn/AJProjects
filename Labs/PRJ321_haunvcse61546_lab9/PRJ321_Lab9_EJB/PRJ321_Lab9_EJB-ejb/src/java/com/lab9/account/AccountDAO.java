/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab9.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Hau
 */
public class AccountDAO implements Serializable {
    
    public boolean checkLogin(String username, String password, DataSource ds) 
            throws SQLException {
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        if (ds == null) {
            System.out.println("Error");
            return false;
        }
        
        con = ds.getConnection();
        String sql = "SELECT * FROM TBL_Account WHERE Username=? AND Password=? ";
        
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            
            rs = stm.executeQuery();
            
            if(rs.next()) {
                result = true;
            }
            
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        
        return result;
    }
    
}
