package dao.repository;

import dao.exception.NonExistingEntityException;
import model.Genre;
import model.entity.Movie;

import java.time.LocalDate;
import java.util.Collection;

public interface MovieRepository extends PersistableRepository<Integer, Movie>{
    Movie findByMovieName(String movieName) throws NonExistingEntityException;
    Collection<Movie> findByPrice(double moviePrice) throws NonExistingEntityException;
    Collection<Movie> findByGenre(Genre genre) throws NonExistingEntityException;
    Collection<Movie> findByDirector(String director) throws NonExistingEntityException;
    Collection<Movie> findByStudio(String studio) throws NonExistingEntityException;

}
