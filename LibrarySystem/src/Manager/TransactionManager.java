/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Been.Transaction;

import DAO.DBTransaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class TransactionManager {

    public int IssueBook(Transaction transaction) throws SQLException {

        DBTransaction dBTransaction = new DBTransaction();

        int TransactionNo = dBTransaction.IssueBook(transaction);

        return TransactionNo;
    }

    public String ReceiveBook(Transaction transaction) throws SQLException {

        String Msg = "";
        DBTransaction dBTransaction = new DBTransaction();
        dBTransaction.ReceiveBook(transaction);

        return Msg;
    }

    public Transaction SelectTransaction(int transactionNo) {

        String Msg = "";
        DBTransaction dBTransaction = new DBTransaction();
        Transaction transaction = dBTransaction.SelectTransaction(transactionNo);

        return transaction;
    }

    public DefaultTableModel getTransaction(String MemberId) {

        DBTransaction db = new DBTransaction();
        // Create New Table
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "IssDate", "ReceiveDate", "ReceiveStatus", "Received"});

        ArrayList<Transaction> list = db.getTransaction(MemberId);

        Iterator<Transaction> iterator = list.iterator();

        while (iterator.hasNext()) {
            Transaction next = iterator.next();

            tableModel.addRow(new Object[]{next.getTransactionNo(), next.getMemberId(), next.getIssDate(), next.getReceiveDate(), next.getReceiveStatus(), next.getReceived()});

        }

        return tableModel;

    }

    public DefaultTableModel Short(String Col, String ShortType, String Text) {

        DBTransaction db = new DBTransaction();
        // Create New Table
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "MemberId", "BookID", "IssDate", "ReceiveDate", "ReceiveStatus", "Received"});

        ArrayList<Transaction> list = db.Short(Col, ShortType, Text);

        Iterator<Transaction> iterator = list.iterator();

        while (iterator.hasNext()) {
            Transaction next = iterator.next();

            tableModel.addRow(new Object[]{next.getTransactionNo(), next.getMemberId(), next.getBookID(), next.getIssDate(), next.getReceiveDate(), next.getReceiveStatus(), next.getReceived()});

        }

        return tableModel;

    }
}
