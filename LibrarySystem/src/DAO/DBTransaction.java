/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Been.Book;
import Been.Transaction;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DBTransaction {

    public int IssueBook(Transaction transaction) throws SQLException {

        int TransactionNo = 0;

        String sql = "INSERT INTO `jayamaga`.`transaction` ( `MemberId`, `BookID`, `IssDate`, `Received`) VALUES ( '" + transaction.getMemberId() + "', '" + transaction.getBookID() + "', '" + transaction.getIssDate() + "', '" + transaction.getReceived() + "');";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        PreparedStatement st;
        try {
            st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            rs.next();

            TransactionNo = rs.getInt(1);
            System.out.println(TransactionNo);

            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBTransaction.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException();

        }
        return TransactionNo;
    }

    public String ReceiveBook(Transaction transaction) throws SQLException {
        String msg = "";
        String sql = "UPDATE jayamaga.transaction SET  ReceiveDate ='" + transaction.getIssDate() + "', ReceiveStatus ='" + transaction.getReceiveStatus() + "', Received='" + transaction.getReceived() + "' WHERE TransactionNo ='" + transaction.getTransactionNo() + "';";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.executeUpdate();

            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;

        }

        return msg;
    }

    public Transaction SelectTransaction(int transactionNo) {

        Transaction transaction = new Transaction();

        String sql = "SELECT * FROM jayamaga.transaction WHERE transaction.TransactionNo ='" + transactionNo + "';";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                transaction.setTransactionNo(rs.getInt(1));
                transaction.setMemberId(rs.getString(2));
                transaction.setBookID(rs.getString(3));
                transaction.setIssDate(rs.getString(4));
                transaction.setReceiveDate(rs.getString(5));
                transaction.setReceiveStatus(rs.getString(6));
                transaction.setReceived(rs.getString(7));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return transaction;
    }

    public ArrayList<Transaction> getTransaction(String MemberId) {

        ArrayList<Transaction> list = new ArrayList();

        String sql = "SELECT * FROM jayamaga.transaction WHERE transaction.MemberId ='" + MemberId + "';";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionNo(rs.getInt(1));
                transaction.setMemberId(rs.getString(2));
                transaction.setBookID(rs.getString(3));
                transaction.setIssDate(rs.getString(4));
                transaction.setReceiveDate(rs.getString(5));
                transaction.setReceiveStatus(rs.getString(6));
                transaction.setReceived(rs.getString(7));

                list.add(transaction);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList<Transaction> Short(String Col, String ShortType, String Text) {

        ArrayList<Transaction> list = new ArrayList();

        String sql = "";
        //  String sql = "SELECT * SELECT * FROM jayamaga.transaction where Memberid='" + Text + "' ORDER BY BookID;";
        // TransactionNo, MemberId, BookID, IssDate, ReceiveDate, ReceiveStatus, Received

        if (Col.equals("MemberId") & ShortType.equals("BookID")) {

            sql = "SELECT * FROM jayamaga.transaction where Memberid='" + Text + "' ORDER BY BookID";
        } else if (Col.equals("MemberId") & ShortType.equals("MemberId")) {

            sql = "SELECT * FROM jayamaga.transaction where Memberid='" + Text + "' ORDER BY MemberId";
        } else if (Col.equals("MemberId") & ShortType.equals("TransactionNo")) {

            sql = "SELECT * FROM jayamaga.transaction where Memberid='" + Text + "' ORDER BY TransactionNo";
        } else if (Col.equals("BookID") & ShortType.equals("BookID")) {

            sql = "SELECT * FROM jayamaga.transaction where BookID='" + Text + "' ORDER BY BookID";
        } else if (Col.equals("BookID") & ShortType.equals("MemberId")) {

            sql = "SELECT * FROM jayamaga.transaction where BookID='" + Text + "' ORDER BY MemberId";
        } else if (Col.equals("BookID") & ShortType.equals("TransactionNo")) {

            sql = "SELECT * FROM jayamaga.transaction where BookID='" + Text + "' ORDER BY TransactionNo";
        } else if (Col.equals("IssDate") & ShortType.equals("BookID")) {

            sql = "SELECT * FROM jayamaga.transaction where IssDate='" + Text + "' ORDER BY BookID";
        } else if (Col.equals("IssDate") & ShortType.equals("MemberId")) {

            sql = "SELECT * FROM jayamaga.transaction where IssDate='" + Text + "' ORDER BY MemberId";
        } else if (Col.equals("IssDate") & ShortType.equals("TransactionNo")) {

            sql = "SELECT * FROM jayamaga.transaction where IssDate='" + Text + "' ORDER BY TransactionNo";
        } else {
            // sql = "SELECT * FROM jayamaga.transaction";
        }

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionNo(rs.getInt(1));
                transaction.setMemberId(rs.getString(2));
                transaction.setBookID(rs.getString(3));
                transaction.setIssDate(rs.getString(4));
                transaction.setReceiveDate(rs.getString(5));
                transaction.setReceiveStatus(rs.getString(6));
                transaction.setReceived(rs.getString(7));

                list.add(transaction);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }
}
