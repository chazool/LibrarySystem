/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Been.User;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DBUser {

    public void ChangePassword(String UserName, String NewPassword) throws SQLException {
        String msg = "";
        String abc = "UPDATE `jayamaga`.`user` SET `Password` = '111' WHERE `UserId` = 'chazool';";
        String sql = "UPDATE `jayamaga`.`user` SET`Password` = '" + NewPassword + "' WHERE `UserId` ='" + UserName + "' ;";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException();
        }

    }

    public void CreateNewUser(User user) throws SQLException {

        String sql = "INSERT INTO `jayamaga`.`user`(`UserId`,`Password`,`Phone`,`Email`,`Address`,`UserType`)VALUES(?,?,?,?,?,?);";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setString(3, user.getPhone());
            st.setString(4, user.getEmail());
            st.setString(5, user.getAddress());
            st.setString(6, user.getUserType());

            st.executeUpdate();

            st.close();
            con.close();
        } catch (SQLException ex) {
            throw new SQLException();

        }

    }

    public String Login(String UserName) {

        String Password = "";

        String sql = "SELECT Password FROM jayamaga.user where UserId='" + UserName + "'; ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Password = rs.getString(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Password;
    }
}
