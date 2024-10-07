package service;

import java.sql.SQLException;

public interface AdminService {
    boolean signIn(int id, String nationalCode) throws SQLException;
}
