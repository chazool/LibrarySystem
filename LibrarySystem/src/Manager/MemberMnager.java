/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Been.Member;
import DAO.DBMember;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class MemberMnager {

    public String NewMember(Member member) throws SQLException {

        DBMember dbMember = new DBMember();

        String MemberId = dbMember.NewMember(member);

        return MemberId;
    }

    public String ModifyMember(Member member) throws SQLException {

        DBMember dbMember = new DBMember();

        dbMember.ModifyMember(member);
        String msg = "";
        return msg;
    }

    public DefaultTableModel SearchMemberId(String MemberId) {
        DBMember dbMember = new DBMember();

        //Create New Table
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Name", "DOB", "Phone", "Email", "Address",});

        ArrayList<Member> list = dbMember.SearchMemberId(MemberId);

        Iterator<Member> iterator = list.iterator();

        while (iterator.hasNext()) {
            Member next = iterator.next();
            tableModel.addRow(new Object[]{next.getMemberId(), next.getMemberName(), next.getDOB(), next.getPhone(), next.getEmail(), next.getAddress()});

        }
        return tableModel;

    }

    public DefaultTableModel SearchMemberName(String memberName) {
        DBMember dbMember = new DBMember();

        //Create New Table
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Name", "DOB", "Phone", "Email", "Address",});

        ArrayList<Member> list = dbMember.SearchMemberName(memberName);

        Iterator<Member> iterator = list.iterator();

        while (iterator.hasNext()) {
            Member next = iterator.next();
            tableModel.addRow(new Object[]{next.getMemberId(), next.getMemberName(), next.getDOB(), next.getPhone(), next.getEmail(), next.getAddress()});

        }
        return tableModel;

    }

    public Member SearchMember(String MemberId) {

        DBMember dbMember = new DBMember();

        Member member = dbMember.SearchMember(MemberId);

        return member;
    }

    public DefaultComboBoxModel getAllMemberID() {

        DBMember dBMember = new DBMember();

         ArrayList<String> list = dBMember.getAllMemberID();
       

        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();

        Iterator<String> irerator = list.iterator();

        while (irerator.hasNext()) {
            comboBoxModel.addElement(irerator.next());
        }

        return comboBoxModel;
    }
}
