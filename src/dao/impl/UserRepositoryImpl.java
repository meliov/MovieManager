package dao.impl;

import dao.UserRepository;
import model.User;

 class UserRepositoryImpl extends AbstractPersistableRepository<Long, User> implements UserRepository {

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
    public User findByUsername(String username) {
        return null;
    }
}
