package dao.repository;

import dao.Identifiable;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.NonExistingEntityException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Generic Repository to manage the lifecycle of an entity
 * @param <K> type of Entity id
 * @param <V> entity that implements Identifiable
 */
public interface Repository<K, V extends Identifiable<K>>{
    /**
     * serves as id generator that can adjusted to current id of entity
     * @param <K> type of Entity ID
     */
//    interface IdGenerator<K>{
//        K getNextId();
//    }
//
//    /**
//     * implementation of IdGenerator for Long type id
//     */
//    class IntegerIdGenerator implements IdGenerator<Integer>{
//        private  Integer id = 0;
//
//        @Override
//        public Integer getNextId() {
//            return ++id;
//        }
//    }

    /**
     * finds all elements of an entity sorted by using comparator
     * @param comparator used to sort the elements
     * @return list of sorted elements
     */
    List<V> findAllSorted(Comparator<V> comparator);

    /**
     * finds all elements of given entity collection
     * @return collection of all elements
     */
    Collection<V> findAll();

    /**
     *
     * @param entity to be created
     * @return the created entity
     */
    V create(V entity) throws  EntityAlreadyExistsException;

    /**
     *
     * @param entity to be updated
     * @return updated entity
     */
    V update(V entity) throws NonExistingEntityException;

    /**
     *
     * finds all values by given id
     * @param id id of entity
     */
    V findById(K id) throws NonExistingEntityException;

    /**
     *
     * @param id id of entity we want to delete
     * @return the deleted entity
     */
    V deleteById(K id) throws NonExistingEntityException;

    /**
     * finds the count of all objects in an entity
     * @return count of the objects
     */
    long count();

    void addAll(Collection<V> entities);
    void clear();
}
