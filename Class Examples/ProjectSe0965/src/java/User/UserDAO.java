/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DBUtils.DBUtil;


/**
 *
 * @author Hau
 */
public class UserDAO implements Serializable {
    public  boolean insertAccount(String username, String password,
            String lastName, boolean roles)
            throws SQLException, ClassNotFoundException {
        Connection con;
        PreparedStatement stm = null;
        boolean result = false;
        
        con = DBUtil.makeConnection();
        if(con==null) {
            throw new SQLException("Could not connect to DB.");
        }
        
        String sql = "INSERT INTO tbl_users(username, password, lastname, "
                        + " isAdmin) VALUES (?, ?, ?, ?)";
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, lastName);
            stm.setBoolean(4, roles);
            
            int rs = stm.executeUpdate();
            if(rs > 0)
                result = true;
        } 
        finally {
            if(stm!=null) 
                stm.close();
            con.close();
        }
        
       return result;
    }
    
    public  boolean updateAccount(String password, boolean roles, String pk)
            throws SQLException, ClassNotFoundException {
        Connection con;
        PreparedStatement stm = null;
        
        con = DBUtil.makeConnection();
        if(con==null) {
            throw new SQLException("Could not connect to DB.");
        }
        
        String sql = "UPDATE tbl_users SET password=? , isAdmin=?"
                    + " WHERE username=?";
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, password);
            stm.setBoolean(2, roles);
            stm.setString(3, pk);
            
            int result = stm.executeUpdate();
            if(result > 0) {
                stm.close();
                con.close();
                return true;
            }
        } 
        finally {
            if(stm!=null) 
                stm.close();
            con.close();
        }
        
       return false;
    }
    
    
    public  boolean deleteAccount(String pk)
            throws SQLException, ClassNotFoundException {
        Connection con;
        PreparedStatement stm = null;
        
        con = DBUtil.makeConnection();
        if(con==null) {
            throw new SQLException("Could not connect to DB.");
        }
        
        String sql = "DELETE FROM tbl_users WHERE username=?";
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, pk);
            
            int result = stm.executeUpdate();
            if(result > 0) {
                stm.close();
                con.close();
                return true;
            }
        } finally {
            if(stm!=null) 
                stm.close();
            con.close();
            
        }
        
       return false;
    }
    
    public  boolean checkLogin(String username, String password) 
            throws ClassNotFoundException, SQLException  {
        Connection con = null ;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tbl_users WHERE username=? AND password=?";
        try {
            con = DBUtil.makeConnection();
            stm = con.prepareCall(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            
            rs = stm.executeQuery();
            if(rs.next()) {
                rs.close();
                stm.close();
                con.close();
                return true;
            }
        }  finally {
            if(rs!=null)
                rs.close();
            if(stm!=null) 
                stm.close();
            if(con!=null)
                con.close();
        }
        
       return false;
        
    }
    
    
    public  List<UserDTO> search(String lastname)
        throws SQLException, ClassNotFoundException {
        Connection con ;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<UserDTO> userList = null;
        
        con = DBUtil.makeConnection();
        if(con==null) {
            throw new SQLException("Could not connect to DB.");
        }
        
        String sql = "SELECT * FROM tbl_users WHERE lastname LIKE ? ";
        try {
            stm = con.prepareCall(sql);
            stm.setString(1, "%"+lastname+"%");
            
            rs = stm.executeQuery();
            
            userList = new ArrayList<>();
            
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
            if(rs != null)
                rs.close();
            if(stm!=null) 
                stm.close();
            con.close();
        }
        
       return userList;
        
    }
}
