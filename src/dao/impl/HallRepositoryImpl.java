package dao.impl;

import dao.exception.NonExistingEntityException;
import dao.repository.HallRepository;
import model.DayOfWeek;
import model.entity.Hall;
import model.entity.Projection;

import java.util.Arrays;
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

    @Override
    public Projection findProjectionByDayAndHour(DayOfWeek day, String hour) throws NonExistingEntityException {
        var proj = entityMap.values()
                .stream()
                .flatMap(e -> Arrays.stream(e.getMovieProgram()))
                .filter(f -> f.getDayOfWeek().equals(day))
                .flatMap(m -> m.getProjections().stream())
                .filter(k -> k.getHour().equals(hour))
                .findAny()
                ;


        if(proj.isEmpty()){
            throw new NonExistingEntityException("Projection on " + day + "at " + hour + "does not exist");
        }
        return proj.get();
    }
}
