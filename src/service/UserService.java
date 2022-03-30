package service;

import dao.exception.EntityAlreadyExistsException;
import model.entity.RegisteredUser;
import model.entity.User;

public interface UserService extends Service<Integer, User> {
}
