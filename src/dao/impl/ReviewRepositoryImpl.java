package dao.impl;

import dao.exception.NonExistingEntityException;
import dao.repository.ReviewRepository;
import model.entity.Movie;
import model.entity.Review;
import model.entity.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ReviewRepositoryImpl extends AbstractRepository<Long, Review> implements ReviewRepository {
    public ReviewRepositoryImpl(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }

    @Override
    public Collection<Review> findByUser(User user) throws NonExistingEntityException {
        var reviews = entityMap.values()
                .stream()
                .filter(e -> e.getPostingUser().equals(user))
                .collect(Collectors.toList());
        if(reviews.isEmpty()){
            throw new NonExistingEntityException("There are no reviews from user = " +  user.getUsername()+ " .");
        }
        return reviews;
    }

    @Override
    public Collection<Review> findByMovie(Movie movie) throws NonExistingEntityException {
        var reviews = entityMap.values()
                .stream()
                .filter(e -> e.getMovie().equals(movie))
                .collect(Collectors.toList());
        if(reviews.isEmpty()){
            throw new NonExistingEntityException("There are no reviews for movie = " +  movie.getMovieName()+ " .");
        }
        return reviews;
    }

    @Override
    public Collection<Review> findByDate(LocalDate date) throws NonExistingEntityException {
        var reviews = entityMap.values()
                .stream()
                .filter(e -> e.getPostingDate().equals(date))
                .collect(Collectors.toList());
        if(reviews.isEmpty()){
            throw new NonExistingEntityException("There are no reviews posted on  " +  date + " .");
        }
        return reviews;
    }

}
