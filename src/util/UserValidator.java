package util;


import dao.exception.ConstraintViolation;
import dao.exception.ConstraintViolationException;
import model.entity.User;

import java.util.ArrayList;
import java.util.List;

import static util.Constants.MAX_LENGTH;
import static util.Constants.MIN_LENGTH;

public class UserValidator extends EntityValidator<Integer,User> {
    List<ConstraintViolation> violations = new ArrayList<>();

    @Override
    public void validate(User user) throws ConstraintViolationException {
        if(user.getUsername().length() < MIN_LENGTH || user.getUsername().length() > MAX_LENGTH){
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "username", user.getUsername(), "Users username must be between " + MIN_LENGTH +" and " + MAX_LENGTH+"." ));
        }
        if(user.getFirstName().length() < MIN_LENGTH || user.getFirstName().length()> MAX_LENGTH){
            violations.add(new ConstraintViolation(user.getClass().getName(),
                    "first name", user.getFirstName(), "Users username must be between " + MIN_LENGTH +" and " + MAX_LENGTH+"." ));
        }
        if(violations.size() > 0){
            setUniqueStringIdentifier(user.getUsername());
            throw new ConstraintViolationException("Invalid user field", violations);
        }

    }
}
