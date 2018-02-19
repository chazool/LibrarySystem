/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Been.Book;
import DAO.DBBook;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class BookManager {

    public String NewBook(Book book) throws SQLException {

        DBBook dbBook = new DBBook();
        String BookId = dbBook.NewBook(book);

        return BookId;
    }

    public String ModifyBook(Book book) throws SQLException {

        DBBook dbBook = new DBBook();

        dbBook.ModifyBook(book);
        String msg = "";

        return msg;
    }

    public Book SearchBookId(String BookId) throws SQLException {

        DBBook dbBook = new DBBook();
        Book book = dbBook.SearchBookId(BookId);

        return book;
    }

    public DefaultTableModel SearchBookTitle(String Title) {

        DBBook dbBook = new DBBook();

        String msg = "";

        // Create New Table
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Title", "Author", "Publisher", "Description", "NoOfPage", "Category", "User Enterss"});

        ArrayList<Book> list = dbBook.SearchBookTitle(Title);

        Iterator<Book> iterator = list.iterator();

        while (iterator.hasNext()) {
            Book next = iterator.next();
            tableModel.addRow(new Object[]{next.getBookId(), next.getTitle(), next.getAuthor(), next.getPublisherName(), next.getDescription(), next.getNoOfPage(), next.getCategory(), next.getUserEntres()});

        }

        return tableModel;
    }

    public DefaultTableModel SearchBookAuthor(String Author) {

        DBBook dbBook = new DBBook();

        String msg = "";

        // Create New Table
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Title", "Author", "Publisher", "Description", "NoOfPage", "Category", "User Enterss"});

        ArrayList<Book> list = dbBook.SearchBookAuthor(Author);

        Iterator<Book> iterator = list.iterator();

        while (iterator.hasNext()) {
            Book next = iterator.next();
            tableModel.addRow(new Object[]{next.getBookId(), next.getTitle(), next.getAuthor(), next.getPublisherName(), next.getDescription(), next.getNoOfPage(), next.getCategory(), next.getUserEntres()});

        }
        return tableModel;
    }

    public DefaultTableModel SearchBookCategory(String Category) {

        DBBook dbBook = new DBBook();

        String msg = "";

        // Create New Table
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Title", "Author", "Publisher", "Description", "NoOfPage", "Category", "User Enterss"});

        ArrayList<Book> list = dbBook.SearchBookCategory(Category);

        Iterator<Book> iterator = list.iterator();

        while (iterator.hasNext()) {
            Book next = iterator.next();
            tableModel.addRow(new Object[]{next.getBookId(), next.getTitle(), next.getAuthor(), next.getPublisherName(), next.getDescription(), next.getNoOfPage(), next.getCategory(), next.getUserEntres()});

        }
        return tableModel;
    }

    public DefaultTableModel ShortBookTitle() {

        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Title", "Author", "Publisher", "Description", "NoOfPage", "Category", "User Enterss"});

        DBBook dbBook = new DBBook();
        ArrayList<Book> list = dbBook.ShortBookTitle();

        Iterator<Book> iterator = list.iterator();

        while (iterator.hasNext()) {
            Book next = iterator.next();
            tableModel.addRow(new Object[]{next.getBookId(), next.getTitle(), next.getAuthor(), next.getPublisherName(), next.getDescription(), next.getNoOfPage(), next.getCategory(), next.getUserEntres()});

        }

        return tableModel;
    }

    public DefaultTableModel ShortBookAuthor() {
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Title", "Author", "Publisher", "Description", "NoOfPage", "Category", "User Enterss"});

        DBBook dbBook = new DBBook();
        ArrayList<Book> list = dbBook.ShortBookAuthor();

        Iterator<Book> iterator = list.iterator();

        while (iterator.hasNext()) {
            Book next = iterator.next();
            tableModel.addRow(new Object[]{next.getBookId(), next.getTitle(), next.getAuthor(), next.getPublisherName(), next.getDescription(), next.getNoOfPage(), next.getCategory(), next.getUserEntres()});

        }

        return tableModel;
    }

    public DefaultComboBoxModel getAllBookID() {

        DBBook dbBook = new DBBook();

        ArrayList<String> list = dbBook.getAllBookID();

        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        Iterator<String> irerator = list.iterator();

        while (irerator.hasNext()) {
            comboBoxModel.addElement(irerator.next());
        }

        return comboBoxModel;
    }
}
