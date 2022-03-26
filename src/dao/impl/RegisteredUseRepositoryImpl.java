package dao.impl;

import dao.repository.RegisteredUserRepository;

public class RegisteredUseRepositoryImpl extends UserRepositoryImpl implements RegisteredUserRepository {
    public RegisteredUseRepositoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }
}
