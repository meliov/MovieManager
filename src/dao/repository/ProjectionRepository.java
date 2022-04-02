package dao.repository;

import dao.exception.NonExistingEntityException;
import model.DayOfWeek;
import model.entity.Movie;
import model.entity.Projection;

import java.util.Collection;

public interface ProjectionRepository extends PersistableRepository<Integer, Projection>{
    Collection<Projection> findByHour(String hour) throws NonExistingEntityException;
    Collection<Projection> findByMovie(Movie movie) throws NonExistingEntityException;

}
