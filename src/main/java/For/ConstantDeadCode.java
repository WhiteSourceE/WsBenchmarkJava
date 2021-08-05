package For;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConstantDeadCode {
    public static Connection dbConnection = null;
    private boolean aBoolean=true;

    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe";
        for(int i=0; i<1;i++){
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }


    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe";
        for(int i=0; i<0;i++){
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
