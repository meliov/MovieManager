package dao.impl;

import dao.RegisteredUserRepository;
import model.RegisteredUser;
import model.User;

public class UserRepositoryImpl extends AbstractPersistableRepository<Long, RegisteredUser> implements RegisteredUserRepository {

    public UserRepositoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    @Override
    public RegisteredUser findByUsername(String username) {
        return null;
    }
}
