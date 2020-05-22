package com.lcj.example.calcite.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;

public class ResultSetFormatter {
    final StringBuilder buf = new StringBuilder();

    public ResultSetFormatter resultSet(ResultSet resultSet) throws SQLException {
        final ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            rowToString(resultSet, metaData);
            buf.append("\n");
        }
        return this;
    }

    /** Converts one row to a string. */
    ResultSetFormatter rowToString(ResultSet resultSet, ResultSetMetaData metaData)
            throws SQLException {
        int n = metaData.getColumnCount();
        if (n > 0) {
            for (int i = 1;; i++) {
                buf.append(metaData.getColumnLabel(i)).append("=")
                        .append(adjustValue(resultSet.getString(i)));
                if (i == n) {
                    break;
                }
                buf.append("; ");
            }
        }
        return this;
    }

    protected String adjustValue(String string) {
        return string;
    }

    public Collection<String> toStringList(ResultSet resultSet, Collection<String> list)
            throws SQLException {
        final ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            rowToString(resultSet, metaData);
            list.add(buf.toString());
            buf.setLength(0);
        }
        return list;
    }

    /** Flushes the buffer and returns its previous contents. */
    public String string() {
        String s = buf.toString();
        buf.setLength(0);
        return s;
    }
}
