package dao.impl;

import dao.exception.NonExistingEntityException;
import dao.repository.UserRepository;
import model.entity.User;

import java.util.Optional;
import java.util.stream.Collectors;

class UserRepositoryImpl extends AbstractRepository<Long, User> implements UserRepository {

    public UserRepositoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
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
