public class Baz implements org.apache.calcite.runtime.Bindable {
    
    public org.apache.calcite.linq4j.Enumerable bind(final org.apache.calcite.DataContext root) {
        final org.apache.calcite.runtime.ResultSetEnumerable enumerable =
                org.apache.calcite.runtime.ResultSetEnumerable.of(
                        (javax.sql.DataSource) root.getRootSchema().getSubSchema("SCOTT")
                                .unwrap(javax.sql.DataSource.class),
                        "SELECT \"ENAME\", \"EMPNO\"\nFROM \"SCOTT\".\"EMP\"\nORDER BY \"EMPNO\" NULLS LAST",
                        new org.apache.calcite.linq4j.function.Function1() {
                            public org.apache.calcite.linq4j.function.Function0 apply(
                                    final java.sql.ResultSet resultSet) {
                                return new org.apache.calcite.linq4j.function.Function0() {
                                    public Object apply() {
                                        try {
                                            final Object[] values = new Object[2];
                                            values[0] = resultSet.getObject(1);
                                            values[1] = resultSet.getShort(2);
                                            if (resultSet.wasNull()) {
                                                values[1] = null;
                                            }
                                            return values;
                                        } catch (java.sql.SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                };
                            }

                            public Object apply(final Object resultSet) {
                                return apply((java.sql.ResultSet) resultSet);
                            }
                        });
        enumerable.setTimeout(root);
        return new org.apache.calcite.linq4j.AbstractEnumerable() {
            public org.apache.calcite.linq4j.Enumerator<String> enumerator() {
                return new org.apache.calcite.linq4j.Enumerator<String>() {
                    public final org.apache.calcite.linq4j.Enumerator<Object[]> inputEnumerator =
                            enumerable.enumerator();

                    public void reset() {
                        inputEnumerator.reset();
                    }

                    public boolean moveNext() {
                        return inputEnumerator.moveNext();
                    }

                    public void close() {
                        inputEnumerator.close();
                    }

                    public Object current() {
                        final Object[] current = (Object[]) inputEnumerator.current();
                        return current[0] == null ? (String) null : current[0].toString();
                    }

                };
            }

        };
    }

    public Class getElementType() {
        return java.lang.String.class;
    }

}
