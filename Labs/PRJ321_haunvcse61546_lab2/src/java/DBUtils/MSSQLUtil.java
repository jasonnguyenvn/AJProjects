/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hau
 */
public class MSSQLUtil implements Serializable {
    public static Connection openConnection()
        throws SQLException, ClassNotFoundException {
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ321_SE61546_Lab";
        
        Connection conn = DriverManager.getConnection(url, "sa", "123456");
        
        return conn;
    }
}
