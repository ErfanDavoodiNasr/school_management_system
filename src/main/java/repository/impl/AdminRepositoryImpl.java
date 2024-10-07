package repository.impl;

import repository.AdminRepository;
import static data.DatabaseQuery.*;
import static data.Database.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public boolean signIn(int id, String nationalCode) throws SQLException {
        PreparedStatement pst = getPreparedStatement(SIGN_IN_ADMIN);
        pst.setInt(1, id);
        pst.setString(2, nationalCode);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
}
