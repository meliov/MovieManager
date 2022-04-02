package dao.repository;

import dao.exception.NonExistingEntityException;
import model.UserStatus;
import model.entity.*;

import java.util.Collection;

public interface UserRepository extends PersistableRepository<Integer, User> {
    User findByUsername(String username) throws NonExistingEntityException;
    User findByEmail(String email) throws NonExistingEntityException;
    boolean containsUsername(String username);


}
