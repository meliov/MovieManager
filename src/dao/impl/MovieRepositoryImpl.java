package dao.impl;

import dao.IdGenerator;
import dao.exception.NonExistingEntityException;
import dao.repository.MovieRepository;
import model.Genre;
import model.entity.Movie;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

class MovieRepositoryImpl extends PersistableRepositoryFileImpl<Integer, Movie> implements MovieRepository {
    public MovieRepositoryImpl(IdGenerator<Integer> idGenerator, String fileName) {
        super(idGenerator, "movie", fileName);
    }

    @Override
    public Movie findByMovieName(String movieName) throws NonExistingEntityException {
        var movie = entityMap.values()
                .stream()
                .filter(e -> e.getMovieName().equals(movieName))
                .findAny();
        if(movie.isEmpty()){
            throw new NonExistingEntityException("Movie with title = " + movieName + " does not exist");
        }
        return movie.get();
    }

    @Override
    public Collection<Movie> findByPrice(double moviePrice) throws NonExistingEntityException {
        var movies = entityMap.values()
                .stream()
                .filter(e -> e.getPrice() == (moviePrice))
                .collect(Collectors.toList());
        if(movies.isEmpty()){
            throw new NonExistingEntityException("There are no movies  with price = " +  moviePrice+ " .");
        }
        return movies;
    }

    @Override
    public Collection<Movie> findByGenre(Genre genre) throws NonExistingEntityException {
        var movies = entityMap.values()
                .stream()
                .filter(e -> e.getGenre().equals(genre))
                .collect(Collectors.toList());
        if(movies.isEmpty()){
            throw new NonExistingEntityException("There are no movies  with genre = " +  genre+ " .");
        }
        return movies;
    }

    @Override
    public Collection<Movie> findByDirector(String director) throws NonExistingEntityException {
        var movies = entityMap.values()
                .stream()
                .filter(e -> e.getDirectorName().equals(director))
                .collect(Collectors.toList());
        if(movies.isEmpty()){
            throw new NonExistingEntityException("There are no movies  from director -> " +  director+ " .");
        }
        return movies;
    }

    @Override
    public Collection<Movie> findByStudio(String studio) throws NonExistingEntityException {
        var movies = entityMap.values()
                .stream()
                .filter(e -> e.getStudioName().equals(studio))
                .collect(Collectors.toList());
        if(movies.isEmpty()){
            throw new NonExistingEntityException("There are no movies  from studio ->" +  studio+ " .");
        }
        return movies;
    }


}
