package fr.eni.dal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTools {
    private static DataSource dataSource;

    static {
        try {
            Context context = new InitialContext();
            JdbcTools.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/cnxSuiviRepas");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return JdbcTools.dataSource.getConnection();
    }
}
