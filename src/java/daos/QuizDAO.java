package daos;

import dbhelper.DBUtils;
import dtos.Answer;
import dtos.Question;
import dtos.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.naming.NamingException;

/**
 *
 * @author macbookpro2018
 */
public class QuizDAO {

    public ArrayList<String> getQuizsIDbyType(String type) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT QuizID FROM Quiz WHERE QuizType=?";

        ArrayList<String> list = new ArrayList();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, type);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    list.add(rs.getString("QuizID"));
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

    public Quiz getQuizbyQuizID(String QuizID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Question WHERE QuizID=?";

        ArrayList<Question> list = new ArrayList();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, QuizID);
                rs = pstm.executeQuery();
                AnswerDAO dao=new AnswerDAO();
                while (rs.next()) {
                    list.add(new Question(rs.getString("QuestionID"),
                            rs.getString("QuizID"),
                            rs.getString("Question"),
                            rs.getString("ImageUrl"),
                            dao.getAnswersbyQuestionID(rs.getString("QuestionID"))));
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
        return new Quiz(list);
    }
    public Quiz getRandomQuiz(String type) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Question WHERE  QuizID in (SELECT QuizID from Quiz where QuizType=?)";

        ArrayList<Question> list = new ArrayList();
        ArrayList<Question> res=new ArrayList();
        try {
            con = DBUtils.makeConnection();
            System.out.println(type);
            if (con != null) {
                pstm = con.prepareStatement(sql);
                          System.out.println(sql);
                pstm.setString(1, type);
                rs = pstm.executeQuery();
                AnswerDAO dao=new AnswerDAO();
                while (rs.next()) {
                    list.add(new Question(rs.getString("QuestionID"),
                            rs.getString("QuizID"),
                            rs.getString("Question"),
                            rs.getString("ImageUrl"),
                            dao.getAnswersbyQuestionID(rs.getString("QuestionID"))));
                    System.out.println(list.size());
                }
            }
            System.out.println("da1o");
            Random random = new Random();
            Question q=new Question();
            int n=25,i;
            if (type.startsWith("B")) n=30;
            for(i=1;i<=n;i++)
            {
                q=list.get(random.nextInt(list.size()));
                System.out.println(i);
                System.out.println(q.getContent());
                boolean check=true;
                for (Question re : res)  if (re.getContent().equals(q.getContent())) {check=false;i--;break;}
                if (check) res.add(q);
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
        return new Quiz(res);
    }

    

 

}
