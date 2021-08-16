package com.example.wsbenchmark.IfStatment;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IfStatement {
    public static Connection dbConnection = null;
    private boolean aBoolean = true;

    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        if (aBoolean) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        } else {
            accountBalanceQuery = "safe";
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }


    void safe(HttpServletRequest req) throws SQLException {

        String accountBalanceQuery = null;
        if (!aBoolean) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        } else {
            accountBalanceQuery = "safe";
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}