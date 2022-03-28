package service.impl;

import dao.Identifiable;
import dao.exception.ConstraintViolationException;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.repository.Repository;
import service.Service;
import util.EntityValidator;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractServiceImpl<K, V extends Identifiable<K>, R extends Repository<K,V>, M extends EntityValidator<K,V>> implements Service<K, V> {
    protected R repository;
    protected M validator;
    private String entityName;

    public AbstractServiceImpl(R repository, M validator, String entityName) {
        this.repository = repository;
        this.validator = validator;
        this.entityName = entityName;
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
    public V create(V entity) throws EntityAlreadyExistsException, InvalidEntityDataException {
        try {
            validator.validate(entity);
        } catch (ConstraintViolationException e) {
            throw new InvalidEntityDataException(
                    String.format("Error creating %s %s.",  entityName,validator.getUniqueStringIdentifier()), e);
        }
        return repository.create(entity);
    }

    @Override
    public V update(V entity) throws NonExistingEntityException, InvalidEntityDataException {
        try {
            validator.validate(entity);
        } catch (ConstraintViolationException e) {
            throw new InvalidEntityDataException(
                    String.format("Error creating %s %s.",  entityName,validator.getUniqueStringIdentifier()), e);
        }
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
