package dao.impl;


import dao.IdGenerator;
import dao.Identifiable;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.NonExistingEntityException;
import dao.repository.PersistableRepository;

import java.util.*;

public abstract class AbstractPersistableRepository<K,V extends Identifiable<K>>
        implements PersistableRepository<K,V> {
    protected Map<K, V> entityMap = new LinkedHashMap<>();
    private IdGenerator<K> idGenerator;
    private String entityName;
    public AbstractPersistableRepository(IdGenerator<K> idGenerator, String string ){
        this.idGenerator = idGenerator;
        this.entityName = string;
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
    public V create(V entity) throws EntityAlreadyExistsException {
        if(entityMap.containsKey(entity.getId())){
            throw new EntityAlreadyExistsException( entityName+ " with id = " + entity.getId() + " already exists.");
        }
        entity.setId(idGenerator.getNextId());
        //comment upper and add new if u want to read from db
        entityMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V update(V entity) throws NonExistingEntityException {
        if(!entityMap.containsKey(entity.getId())){
            throw new NonExistingEntityException(entityName + " with id = " + entity.getId() + " does not exist!");
        }
        entityMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public V findById(K id) throws NonExistingEntityException {

        if(!entityMap.containsKey(id)){
            throw new NonExistingEntityException(entityName + " with id = " + id + " does not exist!");
        }
        return entityMap.get(id);
    }

    @Override
    public V deleteById(K id) throws NonExistingEntityException {
        if(!entityMap.containsKey(id)){
            throw new NonExistingEntityException(entityName + " with id = " + id + " does not exist!");
        }
        return entityMap.remove(id);
    }

    @Override
    public long count() {
        return entityMap.size();
    }



    @Override
    public void addAll(Collection<V> entities) {
        for(var entity: entities) {
            entityMap.put(entity.getId(), entity);
        }
    }

    @Override
    public void clear() {
        entityMap.clear();
    }



    public IdGenerator<K> getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator<K> idGenerator) {
        this.idGenerator = idGenerator;
    }
}










