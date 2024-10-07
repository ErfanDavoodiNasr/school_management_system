package service.impl;

import repository.AdminRepository;
import service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private final AdminRepository ad;

    public AdminServiceImpl(AdminRepository ad) {
        this.ad = ad;
    }

    @Override
    public boolean signIn(int id, String nationalCode) throws SQLException {
        if (ad.signIn(id,nationalCode)){
            return true;
        }
        return false;
    }
}
