package com.example.wsbenchmark.While;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("While")
public class While {
    public static Connection dbConnection = null;

    @GetMapping("bad")
    void bad(HttpServletRequest req) throws SQLException {
        String accountBalanceQuery = null;
        while (Math.random()>0.5) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {

        String accountBalanceQuery = null;
        double random = Math.random();
        boolean b = random >0.5;
        boolean notB = random<=0.5;
        while (b && notB) {
            accountBalanceQuery = "safe" + req.getParameter("user_id");
        }

        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}
