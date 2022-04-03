package service.impl;

import dao.Identifiable;
import dao.exception.ConstraintViolationException;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.repository.PersistableRepository;
import dao.repository.Repository;
import service.Service;
import util.EntityValidator;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractServiceImpl<K, V extends Identifiable<K>, R extends PersistableRepository<K,V>, M extends EntityValidator<K,V>> implements Service<K, V> {
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
        load();
        return repository.findAllSorted(comparator);
    }

    @Override
    public Collection<V> findAll() {
        load();
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
        var created = repository.create(entity);;
        repository.save();
        return created;
    }

    @Override
    public V update(V entity) throws NonExistingEntityException, InvalidEntityDataException {
        load();
        try {
            validator.validate(entity);
        } catch (ConstraintViolationException e) {
            throw new InvalidEntityDataException(
                    String.format("Error creating %s %s.",  entityName,validator.getUniqueStringIdentifier()), e);
        }
        var updated = repository.update(entity);;
        repository.save();
        return updated;
    }

    @Override
    public V findById(K id) throws NonExistingEntityException {
        load();
        return repository.findById(id);
    }

    @Override
    public V deleteById(K id) throws NonExistingEntityException {
        load();
        var deleted = repository.deleteById(id);
        repository.save();
        return deleted;
    }

    @Override
    public long count() {
        load();
        return repository.count();
    }

    @Override
    public void load(){
        repository.load();
    }
}
