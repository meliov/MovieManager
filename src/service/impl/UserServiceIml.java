package service.impl;

import dao.exception.EntityAlreadyExistsException;
import dao.exception.NonExistingEntityException;
import dao.repository.UserRepository;
import model.entity.User;
import service.UserService;
import util.UserValidator;

public class UserServiceIml extends AbstractServiceImpl<Integer, User, UserRepository, UserValidator> implements UserService {

    public UserServiceIml(UserRepository repository, UserValidator validator) {
        super(repository, validator, "user");
    }

}
