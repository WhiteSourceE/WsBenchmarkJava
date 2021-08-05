package Anonymous;


import InnerClasses.Inner1;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class AnonymousC   {

    interface Sql {
        String getSql();
    }

    String input = req.getParameter("user_id");
    public static HttpServletRequest req;
    public static Connection dbConnection ;

    public void bad() throws SQLException {
        Sql sql = new Sql() {
             public String getSql(){
                return "safe" + input;
            }
        };
        String accountBalanceQuery =
                sql.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    void safe(HttpServletRequest req) throws SQLException {
        Sql sql = new Sql() {
            public String getSql(){
                  input.toString();
                return "safe" ;
            }
        };
        String accountBalanceQuery =
                sql.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
