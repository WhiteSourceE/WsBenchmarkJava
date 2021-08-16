package com.example.wsbenchmark.For;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController("constantDeadCode")
public class ConstantDeadCode {
    public static Connection dbConnection = null;
    private boolean aBoolean = true;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe";
        for (int i = 0; i < 1; i++) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        accountBalanceQuery = "safe";
        for (int i = 0; i < 0; i++) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
