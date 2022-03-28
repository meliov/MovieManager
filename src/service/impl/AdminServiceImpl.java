package service.impl;

import dao.exception.EntityAlreadyExistsException;
import dao.exception.NonExistingEntityException;
import dao.repository.AdminRepository;
import dao.repository.UserRepository;
import model.entity.Admin;
import model.entity.User;
import service.AdminService;
import util.UserValidator;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AdminServiceImpl extends UserServiceIml implements AdminService {

    public AdminServiceImpl(AdminRepository repository, UserValidator validator) {
        super(repository, validator);
    }


}
