/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5.Account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lab5.DBUltils.MSSQLUltil;

/**
 *
 * @author Hau
 */
public class AccountDAO implements Serializable {
    public AccountDTO getUserByUsername(String username) 
            throws ClassNotFoundException, SQLException {
        AccountDTO result = null;
        Connection conn = MSSQLUltil.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        if(conn==null)
            throw new SQLException("COULD NOT CONNECT TO DATABSE");
        
        String sql = "SELECT * FROM TBL_Account WHERE Username=? ";
        
        try {
            stm = conn.prepareCall(sql);
            stm.setString(1, username);
            
            rs =  stm.executeQuery();
            
            if(rs.next()) {
                String password = rs.getString("Password");
                String lastname = rs.getString("Lastname");
                boolean isAdmin = rs.getBoolean("isAdmin");
                AccountDTO acc = new AccountDTO(username, password, lastname, 
                                                isAdmin);
                return acc;
            }
            
        } finally {
            if(rs!=null)
                rs.close();
            if(stm!=null)
                stm.close();
            conn.close();
        }
        
        return result;
    }
    
    
    public AccountDTO checkLogin(String username, String password) 
            throws ClassNotFoundException, SQLException {
        AccountDTO result = null;
        Connection conn = MSSQLUltil.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        if(conn==null)
            throw new SQLException("COULD NOT CONNECT TO DATABSE");
        
        String sql = "SELECT * FROM TBL_Account WHERE Username=? AND Password=? ";
        
        try {
            stm = conn.prepareCall(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            
            rs =  stm.executeQuery();
            
            if(rs.next()) {
                String lastname = rs.getString("Lastname");
                boolean isAdmin = rs.getBoolean("isAdmin");
                AccountDTO acc = new AccountDTO(username, password, lastname, 
                                                isAdmin);
                return acc;
            }
            
        } finally {
            if(rs!=null)
                rs.close();
            if(stm!=null)
                stm.close();
            conn.close();
        }
        
        return result;
    }
    
    public List<AccountDTO> searchByLastName(String lastnameToSearch) 
            throws ClassNotFoundException, SQLException {
        ArrayList<AccountDTO> list = new ArrayList<>();
        
        Connection conn = MSSQLUltil.makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        if(conn==null)
            throw new SQLException("COULD NOT CONNECT TO DATABSE");
        
        String sql = "SELECT * FROM TBL_Account WHERE Lastname LIKE ? ";
        
        try {
            stm = conn.prepareCall(sql);
            stm.setString(1, "%"+lastnameToSearch+"%");
            
            rs =  stm.executeQuery();
            
            while(rs.next()) {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String lastname = rs.getString("Lastname");
                boolean isAdmin = rs.getBoolean("isAdmin");
                AccountDTO acc = new AccountDTO(username, password, lastname, 
                                                isAdmin);
                list.add(acc);
            }
            
        } finally {
            if(rs!=null)
                rs.close();
            if(stm!=null)
                stm.close();
            conn.close();
        }
        
        return list;
    }
    
}
