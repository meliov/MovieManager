package dao.impl;

import dao.Identifiable;
import dao.repository.Repository;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.NonExistingEntityException;

import java.util.*;

public abstract class AbstractRepository<K, V extends Identifiable<K>> implements Repository<K, V > {
    protected Map<K, V> entityMap = new LinkedHashMap<>();
    private IdGenerator<K> idGenerator;
    public AbstractRepository(IdGenerator<K> idGenerator ){
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
    public V create(V entity) throws  EntityAlreadyExistsException {
        if(entityMap.containsKey(entity.getId())){
            throw new EntityAlreadyExistsException( "Entity"+ " with id = " + entity.getId() + "already exists.");
        }
        entity.setId(idGenerator.getNextId());
        entityMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V update(V entity) throws NonExistingEntityException {
        if(!entityMap.containsKey(entity.getId())){
            throw new NonExistingEntityException("Entity" + "with id = " + entity.getId() + "does not exist!");
        }
        entityMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V findById(K id) throws NonExistingEntityException {
        if(!entityMap.containsKey(id)){
            throw new NonExistingEntityException("Entity" + "with id = " + id + "does not exist!");
        }
        return entityMap.get(id);
    }

    @Override
    public V deleteById(K id) throws NonExistingEntityException {
        if(!entityMap.containsKey(id)){
            throw new NonExistingEntityException("Entity" + "with id = " + id + "does not exist!");
        }
        return entityMap.remove(id);
    }

    @Override
    public long count() {
        return entityMap.size();
    }
}
