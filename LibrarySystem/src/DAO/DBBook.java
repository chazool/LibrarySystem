/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Been.Book;
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
public class DBBook {

    public String NewBook(Book book) throws SQLException {

        String BookId = "";

        String sql = "INSERT INTO `jayamaga`.`book` (`BookId`,`BookTitle`,`Author`,`PublisherName`,`Description`,`NoofPage`,`Category`,`UserEntres`)VALUES(?,?,?,?,?,?,?,?);";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, book.getBookId());
            st.setString(2, book.getTitle());
            st.setString(3, book.getAuthor());
            st.setString(4, book.getPublisherName());
            st.setString(5, book.getDescription());
            st.setString(6, book.getNoOfPage() + "");
            st.setString(7, book.getCategory());
            st.setString(8, book.getUserEntres());

            st.executeUpdate();

            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException();
        }

        return BookId;

    }

    public String ModifyBook(Book book) throws SQLException {
        String msg = "";

        String sql = "UPDATE `jayamaga`.`book` SET `BookTitle` = ?,`Author` = ?,`PublisherName` = ?,`Description` =?, `NoofPage` = ?,`Category` = ?, `UserEntres` = ? WHERE `BookId` = '" + book.getBookId() + "';";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setString(3, book.getPublisherName());
            st.setString(4, book.getDescription());
            st.setInt(5, book.getNoOfPage());
            st.setString(6, book.getCategory());
            st.setString(7, book.getUserEntres());

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException();
        }

        return msg;
    }

    public ArrayList<Book> SearchBookTitle(String Title) {
        String msg = "";
        ArrayList<Book> list = new ArrayList();

        String sql = "SELECT * FROM jayamaga.book  WHERE book.BookTitle like '%" + Title + "%'; ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString(1));
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisherName(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setNoOfPage(rs.getInt(6));
                book.setCategory(rs.getString(7));
                book.setUserEntres(rs.getString(8));

                list.add(book);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<Book> SearchBookAuthor(String Author) {
        String msg = "";
        ArrayList<Book> list = new ArrayList();

        String sql = "SELECT * FROM jayamaga.book  WHERE book.Author like '%" + Author + "%'; ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString(1));
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisherName(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setNoOfPage(rs.getInt(6));
                book.setCategory(rs.getString(7));
                book.setUserEntres(rs.getString(8));

                list.add(book);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<Book> SearchBookCategory(String Category) {
        String msg = "";
        ArrayList<Book> list = new ArrayList();
        String sql = "SELECT * FROM jayamaga.book  WHERE book.Author='" + Category + "';  ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            Book book = new Book();
            while (rs.next()) {
                book.setBookId(rs.getString(1) + "");
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisherName(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setNoOfPage(rs.getInt(6));
                book.setCategory(rs.getString(7));
                book.setUserEntres(rs.getString(8));

                list.add(book);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Book SearchBookId(String BookId) throws SQLException {

        System.out.println(BookId);
        String sql = "SELECT * FROM jayamaga.book  WHERE book.BookId ='" + BookId + "';";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        Book book = new Book();
        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                book.setBookId(rs.getString(1) + "");
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisherName(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setNoOfPage(rs.getInt(6));
                book.setCategory(rs.getString(7));
                book.setUserEntres(rs.getString(8));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException();
        }

        return book;
    }

    public ArrayList<Book> ShortBookTitle() {

        String msg = "";
        ArrayList<Book> list = new ArrayList();
        String sql = "SELECT * FROM jayamaga.book ORDER BY BookTitle;";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString(1) + "");
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisherName(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setNoOfPage(rs.getInt(6));
                book.setCategory(rs.getString(7));
                book.setUserEntres(rs.getString(8));

                list.add(book);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<Book> ShortBookAuthor() {
        String msg = "";
        ArrayList<Book> list = new ArrayList();
        String sql = "SELECT * FROM jayamaga.book ORDER BY author;";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString(1) + "");
                book.setTitle(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisherName(rs.getString(4));
                book.setDescription(rs.getString(5));
                book.setNoOfPage(rs.getInt(6));
                book.setCategory(rs.getString(7));
                book.setUserEntres(rs.getString(8));

                list.add(book);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<String> getAllBookID() {

        ArrayList<String> list = new ArrayList();
        String msg = "";

        String sql = "SELECT BookId FROM jayamaga.book;";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                list.add(rs.getString(1) + "");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
