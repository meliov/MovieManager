package dao;

import dao.Repository;
import model.RegisteredUser;
import model.User;

public interface UserRepository extends Repository<Long, User> {
    User findByUsername(String username);
}
