/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DBConnection {

    public Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/Jayamaga";
        String username = "root";
        String password = "1234";

        Connection con = null;
        try {
            //register Driver
            Class.forName("com.mysql.jdbc.Driver");

            //creat the Connection
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);

        }
        return con;
    }

}
