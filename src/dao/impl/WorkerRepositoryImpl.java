package dao.impl;

import dao.repository.WorkerRepository;

public class WorkerRepositoryImpl extends UserRepositoryImpl implements WorkerRepository {
    public WorkerRepositoryImpl(IdGenerator<Integer> idGenerator) {
        super(idGenerator);
    }
}
