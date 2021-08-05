package Lambdas;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LambdaExpression1 {
    public static Connection dbConnection = null;

    interface IntegerMath {
        String createSql();
    }

    void bad(HttpServletRequest req) throws SQLException {
        IntegerMath sql = ()->{
            return
                    "safe" + req.getParameter("user_id");
        };
        Statement statement = dbConnection.createStatement();
          statement.executeQuery(sql.createSql());
    }


    void safe(HttpServletRequest req) throws SQLException {
        IntegerMath sql = ()->{
            req.getParameter("user_id");
            return
                    "safe" ;
        };
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(sql.createSql());
    }
}
