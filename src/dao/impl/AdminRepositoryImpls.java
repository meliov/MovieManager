package dao.impl;

import dao.repository.AdminRepository;

public class AdminRepositoryImpls extends UserRepositoryImpl implements AdminRepository {
    public AdminRepositoryImpls(IdGenerator<Integer> idGenerator) {
        super(idGenerator);
    }

}
