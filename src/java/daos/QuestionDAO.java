/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dbhelper.DBUtils;
import dtos.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author OS
 */
public class QuestionDAO {
    public Question getQuestionByID(String ID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Question WHERE QuestionID=?";
        Question res=null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, ID);
                rs = pstm.executeQuery();
                if (rs.next()) {
                            AnswerDAO dao=new AnswerDAO();
                           res=new Question(rs.getString("QuestionID"),
                                   rs.getString("QuizID"), rs.getString("Question"), 
                                   rs.getString("ImageUrl"), dao.getAnswersbyQuestionID(ID));
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
