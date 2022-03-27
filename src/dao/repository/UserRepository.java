package dao.repository;

import dao.exception.NonExistingEntityException;
import model.UserStatus;
import model.entity.User;

public interface UserRepository extends Repository<Integer, User> {
    User findByUsername(String username) throws NonExistingEntityException;
    User findByEmail(String email) throws NonExistingEntityException;

}
