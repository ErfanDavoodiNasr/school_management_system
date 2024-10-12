package data;


import java.sql.*;
import static data.DatabaseInfo.*;

public abstract class Database {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }

    public static PreparedStatement getPreparedStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}
