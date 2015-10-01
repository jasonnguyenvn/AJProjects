/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

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
public class UserDAO implements Serializable {
    
    
    
    public boolean checkLogin(String username, String password, DataSource ds) 
            throws SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        if (ds != null) {
            con = ds.getConnection();
            
            String sql = "SELECT * FROM tbl_users WHERE username=? "
                    + " AND password=? ";
            
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
            
        }
        
        return result;
    }
    
}
