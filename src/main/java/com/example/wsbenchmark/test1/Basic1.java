package com.example.wsbenchmark.test1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@RestController("basic")
public class Basic1 {
    public static Connection dbConnection = null;

    @GetMapping("bad1")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery =
                "safe" + req.getParameter("user_id");
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe1")
    void safe(HttpServletRequest req) throws SQLException {

        PreparedStatement statement = dbConnection.prepareStatement("safe" + "?");
        statement.setString(1, req.getParameter("user_id"));
        statement.executeQuery();
    }
}
