/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dbhelper.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author OS
 */
public class HighScoreDAO {

    public boolean insertHighScore(String username, String quiztype) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "INSERT into HighScore values(?,?,?)";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, username);
                pstm.setString(2, quiztype);
                pstm.setString(3, "0");

                pstm.executeUpdate();
                return true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public String updateHighScore(String username, String quiztype, String score) throws NamingException, SQLException {
        String currentHighScore = getHighScore(username, quiztype);
        System.out.println("xx");
        System.out.println(Integer.parseInt(currentHighScore));
        System.out.println(Integer.parseInt(score));
        if (Integer.parseInt(currentHighScore) >= Integer.parseInt(score)) {
            return currentHighScore;
        }
        Connection con = null;
        PreparedStatement pstm = null;
     
        String sql = "Update HighScore Set Score=? Where UserName=? and QuizType=?";
        System.out.println(username);
        System.out.println(quiztype);
        System.out.println(score);
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, score);
                pstm.setString(2, username);
                pstm.setString(3, quiztype);
                
                pstm.executeUpdate();
               
                return score;
            }
        } finally {
            
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return currentHighScore;
    }

    public String getHighScore(String username, String quiztype) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT Score FROM HighScore WHERE UserName=? and  QuizType=?";
        String res = "0";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, username);
                pstm.setString(2, quiztype);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    res = rs.getString("Score").trim();
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return res;
    }
}
