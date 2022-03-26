package dao.impl;

import dao.repository.AdminRepository;

public class AdminRepositoryImpls extends UserRepositoryImpl implements AdminRepository {
    public AdminRepositoryImpls(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }

}
