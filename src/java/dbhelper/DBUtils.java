package dbhelper;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class DBUtils {

    public static Connection makeConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2. Tao object ket noi CSDL gom 3 param: url, username, pwd
            String url = "jdbc:sqlserver://192.168.165.2:1433;databaseName=GroupAssignment_PRJ";
            Connection con = DriverManager.getConnection(url, "sa", "123123");
            return con;
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
    
//    public static Connection getConnection() throws Exception{
//        Context context = new InitialContext();
//        Context end = (Context) context.lookup("java:comp/env");
//        DataSource ds = (DataSource) end.lookup("DBConnection");
//        Connection conn = ds.getConnection();
//        return conn;
//    }
    
//  public static void main(String[] agrs){
//      Connection con = makeConnection();
//      if(con == null) System.out.println("sai");
//      else System.out.println("ok");
//  }
}
