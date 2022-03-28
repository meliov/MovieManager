package service.impl;

import dao.Identifiable;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.NonExistingEntityException;
import dao.repository.Repository;
import dao.repository.UserRepository;
import service.Service;
import util.AbstractValidator;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractServiceImpl<K, V extends Identifiable<K>, R extends Repository<K,V> , M extends AbstractValidator<V>> implements Service<K, V> {
    protected R repository;
    protected M validator;

    public AbstractServiceImpl(R repository, M validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<V> findAllSorted(Comparator<V> comparator) {
        return repository.findAllSorted(comparator);
    }

    @Override
    public Collection<V> findAll() {
        return repository.findAll();
    }

    @Override
    public V create(V entity) throws EntityAlreadyExistsException {
        validator.validate(entity);
        return repository.create(entity);
    }

    @Override
    public V update(V entity) throws NonExistingEntityException {
        validator.validate(entity);
        return repository.update(entity);
    }

    @Override
    public V findById(K id) throws NonExistingEntityException {
        return repository.findById(id);
    }

    @Override
    public V deleteById(K id) throws NonExistingEntityException {
        return repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
