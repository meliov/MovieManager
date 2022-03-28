package service;

import dao.Identifiable;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.repository.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Service<K, V extends Identifiable<K>> {

    List<V> findAllSorted(Comparator<V> comparator);
    Collection<V> findAll();
    V create(V entity) throws EntityAlreadyExistsException, InvalidEntityDataException;
    V update(V entity) throws NonExistingEntityException, InvalidEntityDataException;
    V findById(K id) throws NonExistingEntityException;
    V deleteById(K id) throws NonExistingEntityException;
    long count();
}
