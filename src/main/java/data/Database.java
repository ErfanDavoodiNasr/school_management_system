package data;


import java.sql.*;
import static data.DatabaseInfo.*;

public abstract class Database {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }

    private static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public static ResultSet getResultSet(String query) throws SQLException {
        return getStatement().executeQuery(query);
    }
    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}
