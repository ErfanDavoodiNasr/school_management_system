package repository;

import java.sql.SQLException;

public interface AdminRepository {
    boolean signIn(int id, String nationalCode) throws SQLException;
}
