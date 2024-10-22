package data;


import java.sql.*;
import static data.DatabaseInfo.*;

public abstract class Database {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
