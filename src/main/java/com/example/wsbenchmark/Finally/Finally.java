package com.example.wsbenchmark.Finally;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

public class Finally {

    public static Connection dbConnection = null;

    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery;
        try {
            accountBalanceQuery = "safe";
        } catch (Exception e) {
        } finally {
            accountBalanceQuery = req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }


    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery;
        try {
            accountBalanceQuery = req.getParameter("user_id");
        } catch (Exception e) {
        } finally {
            accountBalanceQuery = "safe";
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

}
