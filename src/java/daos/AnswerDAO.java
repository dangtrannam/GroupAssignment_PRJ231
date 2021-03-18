/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dbhelper.DBUtils;
import dtos.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author OS
 */
public class AnswerDAO {
   
    public boolean checkAns(String ID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Answer WHERE AnswerID=?";
        boolean res=false;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, ID);
                rs = pstm.executeQuery();
                if (rs.next()) {
                            if (rs.getString("isCorrect").trim().equals("true")) res=true;
                           
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
    
    public ArrayList<Answer> getAnswersbyQuestionID(String QuestionID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Answer WHERE QuestionID=?";

        ArrayList<Answer> list = new ArrayList();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, QuestionID);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    list.add(new Answer(rs.getString("QuestionID"),
                            rs.getString("Answer"),
                            rs.getString("isCorrect"),
                            rs.getString("AnswerID")));
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
        return list;
    }
}
