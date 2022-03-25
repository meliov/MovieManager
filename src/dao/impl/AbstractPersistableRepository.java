package dao.impl;

import dao.Identifiable;
import dao.Persistable;
import dao.Repository;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.NonExistingEntityException;

import java.util.*;

public abstract class AbstractPersistableRepository<K, V extends Identifiable<K>> implements Repository<K, V >, Persistable {
    private Map<K, V> entityMap = new LinkedHashMap<>();
    private IdGenerator<K> idGenerator;
    public AbstractPersistableRepository(IdGenerator<K> idGenerator ){
        this.idGenerator = idGenerator;
    }

    @Override
    public List<V> findAllSorted(Comparator<V> comparator) {
        List<V> sorted = new ArrayList<>(entityMap.values());
        sorted.sort(comparator);
        return sorted;
    }

    @Override
    public Collection<V> findAll() {
        return entityMap.values();
    }

    @Override
    public V create(V entity, String entityName) throws  EntityAlreadyExistsException {
        if(entityMap.containsKey(entity.getId())){
            throw new EntityAlreadyExistsException( entityName + " with id = " + entity.getId() + "already exists.");
        }
        entity.setId(idGenerator.getNextId());
        entityMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V update(V entity, String entityName) throws NonExistingEntityException {
        if(!entityMap.containsKey(entity.getId())){
            throw new NonExistingEntityException(entityName + "with id = " + entity.getId() + "does not exist!");
        }
        entityMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V findById(K id, String entityName) throws NonExistingEntityException {
        if(!entityMap.containsKey(id)){
            throw new NonExistingEntityException(entityName + "with id = " + id + "does not exist!");
        }
        return entityMap.get(id);
    }

    @Override
    public V deleteById(K id, String entityName) throws NonExistingEntityException {
        if(!entityMap.containsKey(id)){
            throw new NonExistingEntityException(entityName + "with id = " + id + "does not exist!");
        }
        return entityMap.remove(id);
    }

    @Override
    public long count() {
        return entityMap.size();
    }
}
