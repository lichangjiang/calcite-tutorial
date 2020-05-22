package com.lcj.example.calcite.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.function.Consumer;
import com.lcj.example.calcite.TestUtil;
import com.lcj.example.calcite.util.ResultSetFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JdbcAdapterTest {

    @Test
    public void singleSourceTest() throws SQLException {
        Properties config = new Properties();
        config.put("model", TestUtil.resourcePath("singleSource.json"));
        config.put("lex", "MYSQL");
        String sql = "select s.name,c.name from student as s join colleage as c on s.cid = c.id";

        try (Connection con = DriverManager.getConnection("jdbc:calcite:", config)) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    printRs(rs);
                }
            }
        }
    }


    @Test
    public void multiSourceTest() throws SQLException {
        Properties config = new Properties();
        config.put("model", TestUtil.resourcePath("multiSource.json"));
        config.put("lex", "MYSQL");
        String sql =
                "SELECT s.name,c.name FROM db1.student AS s join db2.colleage AS c on s.cid = c.id";

        try (Connection con = DriverManager.getConnection("jdbc:calcite:", config)) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    printRs(rs);
                }
            }
        }
    }

    @Test
    public void testExplainSql() throws SQLException {
        String sql =
                "EXPLAIN PLAN FOR select s.name,c.name from student as s join colleage as c on s.cid = c.id";
        executeSql("singleSource.json", sql, rs -> {
            Assertions.assertDoesNotThrow(() -> {
                System.out.println(new ResultSetFormatter().resultSet(rs).string());
            });
        });

        sql = "EXPLAIN PLAN FOR SELECT s.name,c.name FROM db1.student AS s join db2.colleage AS c on s.cid = c.id";
        executeSql("multiSource.json", sql, rs -> {
            Assertions.assertDoesNotThrow(() -> {
                System.out.println(new ResultSetFormatter().resultSet(rs).string());
            });
        });
    }

    private void executeSql(String model, String sql, Consumer<ResultSet> fun) throws SQLException {
        Properties config = new Properties();
        config.put("model", TestUtil.resourcePath(model));
        config.put("lex", "MYSQL");

        try (Connection con = DriverManager.getConnection("jdbc:calcite:", config)) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    fun.accept(rs);
                }
            }
        }
    }

    private void printRs(ResultSet rs) throws SQLException {
        int count = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= count; i++) {
                String label = rs.getMetaData().getColumnLabel(i);
                Object val = rs.getObject(i);
                String value = "null";
                if (val != null)
                    value = val.toString();
                sb.append("label:" + value);
                if (i != count)
                    sb.append(" , ");
            }
            System.out.println(sb);
        }
    }


}
