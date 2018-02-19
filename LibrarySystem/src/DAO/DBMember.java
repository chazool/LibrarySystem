/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Been.Member;
import DB.DBConnection;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
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
public class DBMember {

    public String NewMember(Member member) throws SQLException {

        String MemberId = "";
        System.out.println(member.getMemberId());
        String sql = "INSERT INTO `jayamaga`.`member` VALUES (?, ?, ?,?,?,?);";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, member.getMemberId());
            st.setString(2, member.getMemberName());
            st.setString(3, member.getDOB());
            st.setString(4, member.getPhone());
            st.setString(5, member.getEmail());
            st.setString(6, member.getAddress());

            st.executeUpdate();

            st.close();
            con.close();
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return MemberId;
    }

    public String ModifyMember(Member member) throws SQLException {

        String msg = "";

        String sql = "UPDATE `jayamaga`.`member` SET `MemberName` = ?, `DOB` = ?,`Phone` =?,`Email` =?,`Address` = ? WHERE `MemberId` = '" + member.getMemberId() + "';";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, member.getMemberName());
            st.setString(2, member.getDOB());
            st.setString(3, member.getPhone());
            st.setString(4, member.getEmail());
            st.setString(5, member.getAddress());

            st.executeUpdate();

            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException();

        }

        return msg;
    }

    public ArrayList<Member> SearchMemberId(String MemberId) {

        ArrayList<Member> list = new ArrayList();

        String sql = "SELECT * FROM jayamaga.member where memberId='" + MemberId + "'; ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            Member member = new Member();
            while (rs.next()) {
                member.setMemberId(rs.getString(1));
                member.setMemberName(rs.getString(2));
                member.setDOB(rs.getString(3));
                member.setPhone(rs.getString(4));
                member.setEmail(rs.getString(5));
                member.setAddress(rs.getString(6));

                list.add(member);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<Member> SearchMemberName(String MemberName) {
        ArrayList<Member> list = new ArrayList();

        String sql = "SELECT * FROM jayamaga.member where MemberName like'%" + MemberName + "%'; ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString(1));
                member.setMemberName(rs.getString(2));
                member.setDOB(rs.getString(3));
                member.setPhone(rs.getString(4));
                member.setEmail(rs.getString(5));
                member.setAddress(rs.getString(6));

                list.add(member);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Member SearchMember(String MemberId) {

        Member member = new Member();

        String sql = "SELECT * FROM jayamaga.member where memberId='" + MemberId + "'; ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                member.setMemberId(rs.getString(1));
                member.setMemberName(rs.getString(2));
                member.setDOB(rs.getString(3));
                member.setPhone(rs.getString(4));
                member.setEmail(rs.getString(5));
                member.setAddress(rs.getString(6));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return member;
    }

    public ArrayList<String> getAllMemberID() {

        ArrayList<String> list = new ArrayList();

        String sql = "SELECT memberId FROM jayamaga.member;  ";

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        try {
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1) );
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
