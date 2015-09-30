/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5.DBUltils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hau
 */
public class MSSQLUltil {
    public static Connection makeConnection()
        throws ClassNotFoundException, SQLException {
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ321_SE61546_lab5";
        Connection con = DriverManager.getConnection(url, "sa", "123456");

        return con;
    }
}
