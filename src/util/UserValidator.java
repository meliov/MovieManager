package util;


import dao.DaoFactory;
import dao.exception.ConstraintViolation;
import dao.exception.ConstraintViolationException;
import dao.exception.NonExistingEntityException;
import dao.impl.DaoFactoryImpl;
import dao.repository.UserRepository;
import model.entity.User;

import java.util.ArrayList;
import java.util.List;

import static util.Constants.*;
import static util.Regex.*;

public class UserValidator extends EntityValidator<Integer,User> {

    private DaoFactory daoFactory = new DaoFactoryImpl();
    private UserRepository userRepository = daoFactory.createUserRepository("users.db");
    @Override
    public void validate(User user, boolean update) throws ConstraintViolationException {
        List<ConstraintViolation> violations = new ArrayList<>();
        if(!Regex.regexValidation(user.getUsername(), USER_NAMES_REGEX)){
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "username", user.getUsername(), "Users username must be between " + NAME_MIN_LENGTH +" and " + NAME_MAX_LENGTH +"." ));
        }
        if(!Regex.regexValidation(user.getFirstName(),USER_FIRST_LAST_NAME_REGEX)){
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "first name", user.getFirstName(), "Users first name must be between " + NAME_MIN_LENGTH +" and " + NAME_MAX_LENGTH +"." ));
        }
        if(!Regex.regexValidation(user.getLastName(),USER_FIRST_LAST_NAME_REGEX)){
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "last name", user.getFirstName(), "Users last name must be between " + NAME_MIN_LENGTH +" and " + NAME_MAX_LENGTH +"." ));
        }
        if(!Regex.regexValidation(user.getPassword(),USER_PASS_REGEX)){
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "password", user.getFirstName(), "Users password must be between " + PASS_MIN_LENGTH +" and " + PASS_MAX_LENGTH +"." ));
        }
        if(!Regex.regexValidation(user.getEmail(),USER_EMAIL_REGEX)){
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "email", user.getFirstName(), "User email is not valid" ));
        }
        userRepository.load();
        if(!update){
        if(userRepository.containsUsername(user.getUsername())) {
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "username", user.getFirstName(), "Username already exists!"));
        }
        }

        if(violations.size() > 0){
            setUniqueStringIdentifier(user.getUsername());
            throw new ConstraintViolationException("Invalid user field", violations);
        }

    }
}
