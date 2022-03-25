package dao;

import dao.Repository;
import model.RegisteredUser;
import model.User;

public interface RegisteredUserRepository extends Repository<Long, RegisteredUser> {
    RegisteredUser findByUsername(String username);
}
