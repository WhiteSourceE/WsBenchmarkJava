package test1;

import testcasesupport.IO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic1 {
    public static Connection dbConnection = null;

    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery =
                "safe" + req.getParameter("user_id");
        Statement statement = dbConnection.createStatement();
          statement.executeQuery(accountBalanceQuery);
    }


    void safe(HttpServletRequest req) throws SQLException {

        PreparedStatement statement = dbConnection.prepareStatement("safe" + "?");
        statement.setString(1, req.getParameter("user_id"));
        statement.executeQuery();
    }
}
