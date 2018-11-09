/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author fernando.lcoutinho
 */
public class ConnectionUtils {
    
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        String dbURL = "jdbc:mysql?//localhost:3306/estacionamentoPOO";
        Properties prop = new Properties();
        prop.put("user","root");
        prop.put("password", "");
        prop.put("ServerTimezone", "UTC");
        con = DriverManager.getConnection(dbURL,prop);
        
        return con;
    }
    
}
