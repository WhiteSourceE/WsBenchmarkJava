package Try;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

public class TryTest {

  public static Connection dbConnection = null;

  void bad(HttpServletRequest req) throws SQLException {
    String accountBalanceQuery;
    try {
      accountBalanceQuery = "safe";
    } catch (Exception e) {
      accountBalanceQuery = req.getParameter("user_id");
    }
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(accountBalanceQuery);
  }


  void safe(HttpServletRequest req) throws SQLException {
    String accountBalanceQuery = req.getParameter("user_id");;
    try {
      accountBalanceQuery = "safe";
    } catch (Exception e) {
      accountBalanceQuery = "safe";
    }
    Statement statement = dbConnection.createStatement();
    statement.executeQuery(accountBalanceQuery);
  }

}
