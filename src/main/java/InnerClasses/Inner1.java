package InnerClasses;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Inner1 {
    public static HttpServletRequest req;
    String input = req.getParameter("user_id");

    class Inner{

        String getSql(){
            return "safe" + input;
        }

    }


    class InnerS{

        String getSql(){
            input.toString();
            return "safe" ;
        }

    }
    public static Connection dbConnection = null;

    void bad(HttpServletRequest req) throws SQLException {
        Inner inner = this.new Inner();
        String accountBalanceQuery =
                inner.getSql();
        Statement statement = dbConnection.createStatement();
          statement.executeQuery(accountBalanceQuery);
    }


    void safe(HttpServletRequest req) throws SQLException {
        InnerS inner = this.new InnerS();
        String accountBalanceQuery =
                inner.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
