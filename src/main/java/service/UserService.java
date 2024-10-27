package service;

import java.sql.SQLException;

public interface UserService {
    void signIn(Integer id, String nationalCode) throws SQLException;
}
