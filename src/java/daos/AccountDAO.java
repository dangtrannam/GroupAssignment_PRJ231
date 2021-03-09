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

    public String login(Account acc) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
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
        return "";
    }

    public boolean register(Account acc) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;

        String sql = "INSERT into Account values(?,?,?)";
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                pstm.setString(1, acc.getUserName());
                pstm.setString(2, acc.getPassword());
                pstm.setString(3, acc.getRole());

                pstm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public static void main(String[] agrs) throws NamingException, SQLException{
        AccountDAO accDAO = new AccountDAO();
        Account acc = new Account("user1","123123","user");
        boolean check = accDAO.register(acc);
        System.out.println(check);
    }

}
