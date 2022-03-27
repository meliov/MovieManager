package dao.repository;

import dao.exception.NonExistingEntityException;
import model.entity.Hall;

import java.util.Collection;

public interface HallRepository extends Repository<Integer, Hall>{
    Collection<Hall> findHallByCapacity(int capacity) throws NonExistingEntityException;
}
