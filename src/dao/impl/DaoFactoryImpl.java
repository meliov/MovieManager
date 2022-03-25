package dao.impl;

import dao.DaoFactory;
import dao.UserRepository;
import dao.Repository;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserRepository createRegisteredUserRepository() {
        return new UserRepositoryImpl(new Repository.LongIdGenerator());
    }
}
