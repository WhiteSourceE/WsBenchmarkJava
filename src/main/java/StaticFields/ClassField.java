package StaticFields;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassField {
    public static Connection dbConnection = null;
    private boolean aBoolean=true;
    private static String accountBalanceQuery;

    void bad(HttpServletRequest req) throws SQLException {
        accountBalanceQuery = "safe" + req.getParameter("user_id");
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }


    void init(){
        accountBalanceQuery = "safe";
    }

    void safe(HttpServletRequest req) throws SQLException {
        accountBalanceQuery = "safe" + req.getParameter("user_id");
        init();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
