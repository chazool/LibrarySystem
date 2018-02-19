/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Been;

/**
 *
 * @author DELL
 */
public class Transaction {

    private int TransactionNo;
    private String MemberId;
    private String BookID;
    private String IssDate;
    private String ReceiveDate;
    private String ReceiveStatus;
  private  String Received;

    

   

    public String getIssDate() {
        return IssDate;
    }

    public void setIssDate(String IssDate) {
        this.IssDate = IssDate;
    }

    public String getReceiveDate() {
        return ReceiveDate;
    }

    public void setReceiveDate(String ReceiveDate) {
        this.ReceiveDate = ReceiveDate;
    }

    public String getReceiveStatus() {
        return ReceiveStatus;
    }

    public void setReceiveStatus(String ReceiveStatus) {
        this.ReceiveStatus = ReceiveStatus;
    }

   

    public int getTransactionNo() {
        return TransactionNo;
    }

    public void setTransactionNo(int TransactionNo) {
        this.TransactionNo = TransactionNo;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getReceived() {
        return Received;
    }

    public void setReceived(String Received) {
        this.Received = Received;
    }

}
