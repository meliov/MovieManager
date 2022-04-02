package dao.impl;

import dao.IdGenerator;
import dao.exception.NonExistingEntityException;
import dao.repository.UserRepository;
import model.entity.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

class UserRepositoryImpl extends PersistableRepositoryFileImpl<Integer, User> implements UserRepository {

    public UserRepositoryImpl(IdGenerator<Integer> idGenerator, String fileName) {
        super(idGenerator, "user", fileName);
    }


    @Override
    public User findByUsername(String username) throws NonExistingEntityException {
        var user = entityMap.values()
                .stream()
                .filter(e -> e.getUsername().equals(username))
                .findAny();
        if(user.isEmpty()){
            throw new NonExistingEntityException("User with username = " + username + " does not exist");
        }
        return user.get();
    }

     @Override
     public User findByEmail(String email) throws NonExistingEntityException {
         var user = entityMap.values()
                 .stream()
                 .filter(e -> e.getEmail().equals(email))
                 .findAny();
         if(user.isEmpty()){
             throw new NonExistingEntityException("User with username = " + email + " does not exist");
         }
         return user.get();
     }

 }
