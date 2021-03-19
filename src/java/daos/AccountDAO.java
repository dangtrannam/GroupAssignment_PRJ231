package daos;

import dbhelper.DBUtils;
import dtos.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author macbookpro2018
 */
public class AccountDAO {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
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

    public String login(Account acc) throws NamingException, SQLException {

        String sql = "SELECT * FROM Account WHERE UserName=?";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, acc.getUserName());
                rs = pstm.executeQuery();

                if (rs.next()) {
                    String pass = rs.getString("Password");
                    String role = rs.getString("Role");
                    if (acc.getPassword().equals(pass)) {
                        return role;
                    } else {
                        return "";
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return "";
    }

    public boolean register(Account acc) throws NamingException, SQLException {

        String sql = "INSERT into Account values(?,?,?)";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, acc.getUserName());
                pstm.setString(2, acc.getPassword());
                pstm.setString(3, acc.getRole());

                pstm.executeUpdate();
                HighScoreDAO dao=new HighScoreDAO();
                dao.insertHighScore(acc.getUserName(), "A1");
                dao.insertHighScore(acc.getUserName(), "A2");
                dao.insertHighScore(acc.getUserName(), "B1");
                dao.insertHighScore(acc.getUserName(), "B2");
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public boolean changePassword(Account acc) throws Exception{
        String sql = "Update Account Set Password=? Where UserName=?";
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, acc.getPassword());
                pstm.setString(2, acc.getUserName());
                
                if (pstm.executeUpdate() > 0) {
                    return true;
                }
            }
        }finally{
            closeConnection();
        }
        return false;
    }

//    public static void main(String[] agrs) throws NamingException, SQLException {
//        AccountDAO accDAO = new AccountDAO();
//        Account acc = new Account("user1", "123123", "user");
//        boolean check = accDAO.register(acc);
//        System.out.println(check);
//    }

}
