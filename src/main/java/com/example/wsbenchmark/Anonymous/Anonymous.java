package com.example.wsbenchmark.Anonymous;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("anonymous")
class AnonymousC {

    interface Sql {
        String getSql();
    }

    String input = "";//req.getParameter("user_id");
    public static HttpServletRequest req;
    public static Connection dbConnection;

    @GetMapping("bad")
    public void bad() throws SQLException {
        Sql sql = new Sql() {
            public String getSql() {
                return "safe" + input;
            }
        };
        String accountBalanceQuery =
                sql.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }

    @GetMapping("safe")
    void safe(HttpServletRequest req) throws SQLException {
        Sql sql = new Sql() {
            public String getSql() {
                input.toString();
                return "safe";
            }
        };
        String accountBalanceQuery =
                sql.getSql();
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(accountBalanceQuery);
    }
}