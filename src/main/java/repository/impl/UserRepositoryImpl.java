package repository.impl;

import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static data.Database.getConnection;
import static util.Help.println;

public class UserRepositoryImpl implements UserRepository {
    private static final String GET_USER_ROLE = """
            SELECT u.role
            from users u
            where u.national_code = ?;
            """;
    @Override
    public String getRoleByNationalCode(String nationalCode) {
        String role = "";
        try(Connection conn = getConnection()){
            PreparedStatement ps = conn.prepareStatement(GET_USER_ROLE);
            ps.setString(1, nationalCode);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                role = rs.getString("role");
            }
        }catch (Exception e){
            println(e.getMessage());
        }
        return role;
    }
}
