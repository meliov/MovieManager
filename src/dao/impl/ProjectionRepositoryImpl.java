package dao.impl;

import dao.IdGenerator;
import dao.exception.NonExistingEntityException;
import dao.repository.ProjectionRepository;
import model.DayOfWeek;
import model.entity.Movie;
import model.entity.Projection;

import java.util.Collection;
import java.util.stream.Collectors;

 class ProjectionRepositoryImpl extends PersistableRepositoryFileImpl<Integer, Projection> implements ProjectionRepository {
    public ProjectionRepositoryImpl(IdGenerator<Integer> idGenerator, String fileName) {
        super(idGenerator, "projection", fileName);
    }

    @Override
    public Collection<Projection> findByHour(String hour) throws NonExistingEntityException {
        var movies = entityMap.values()
                .stream()
                .filter(e -> e.getHour().equals(hour))
                .collect(Collectors.toList());
        if(movies.isEmpty()){
            throw new NonExistingEntityException("There are no projections at  " +  hour + " .");
        }
        return movies;
    }

    @Override
    public Collection<Projection> findByMovie(Movie movie) throws NonExistingEntityException {
        load();
        var movies = entityMap.values()
                .stream()
                .filter(e -> e.getMovie().equals(movie))
                .collect(Collectors.toList());
        if(movies.isEmpty()){
            throw new NonExistingEntityException("There are no projections for  " +  movie.getMovieName() + " .");
        }
        return movies;
    }

}
