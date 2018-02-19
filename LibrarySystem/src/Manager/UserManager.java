/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Been.User;
import DAO.DBUser;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class UserManager {

    public String ChangePassword(String Username, String OldPassword, String NewPassword, String RetypePassword) throws SQLException {
        DBUser dbuser = new DBUser();
        String Password = dbuser.Login(Username);
        String msg = "";

        if (Password.equals(OldPassword)) {

            if (NewPassword.equals(RetypePassword)) {

                dbuser.ChangePassword(Username, NewPassword);
            } else {
                msg = "Password Not Match";
            }

        } else {
            msg = "Invalid Old Password";
        }

        return msg;
    }

    public String CreateNewUser(User user) throws SQLException {

        String msg = "";

        DBUser dBUser = new DBUser();
        dBUser.CreateNewUser(user);

        return msg;
    }

    public boolean Login(String UserName, String Password) throws NullPointerException {

        boolean Result;
        DBUser dbUser = new DBUser();

        String dbPassword = dbUser.Login(UserName);

        if (dbPassword.equals(Password)) {
            Result = true;
        } else {
            Result = false;
            throw new NullPointerException();
        }
        return Result;
    }

}
