package dao.impl;

import dao.exception.NonExistingEntityException;
import dao.repository.HallRepository;
import model.entity.Hall;

import java.util.Collection;
import java.util.stream.Collectors;

public class HallRepositoryImpl extends AbstractRepository<Integer, Hall> implements HallRepository {
    public HallRepositoryImpl(IdGenerator<Integer> idGenerator) {
        super(idGenerator);
    }

    @Override
    public Collection<Hall> findHallByCapacity(int capacity) throws NonExistingEntityException {
        var movies = entityMap.values()
                .stream()
                .filter(e -> e.getCapacity() == capacity)
                .collect(Collectors.toList());
        if(movies.isEmpty()){
            throw new NonExistingEntityException("There are no halls  with capacity = " +  capacity+ " .");
        }
        return movies;
    }
}
