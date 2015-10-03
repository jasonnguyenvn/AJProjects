/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private List<UserDTO> userList;

    public List<UserDTO> getUserList() {
        return userList;
    }
    
    public  void search(String lastname, DataSource ds)
        throws SQLException {
        Connection con ;
        PreparedStatement stm = null;
        ResultSet rs = null;
        userList = null;
        
        con = ds.getConnection();
        if(con==null) {
            throw new SQLException("Could not connect to DB.");
        }
        
        String sql = "SELECT * FROM tbl_users WHERE lastname LIKE ? ";
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, "%"+lastname+"%");
            
            rs = stm.executeQuery();
            
            userList = new ArrayList<UserDTO>();
            
            while(rs.next()) {
                String usrName = rs.getString("username");
                String usrPassword = rs.getString("password");
                String usrLastname = rs.getString("lastname");
                boolean usrIsAdmin = rs.getBoolean("isAdmin");
                
                UserDTO currentUsr = new UserDTO(usrName, usrPassword, 
                                        usrLastname, usrIsAdmin);
                userList.add(currentUsr);
            }
            
        } finally {
            if(rs != null) {
                rs.close();
            }
            if(stm!=null) {
                stm.close();
            }
            con.close();
        }
        
    }
    
}
