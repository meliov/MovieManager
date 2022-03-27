package dao.repository;

import dao.exception.NonExistingEntityException;
import model.entity.Movie;
import model.entity.Review;
import model.entity.User;

import java.time.LocalDate;
import java.util.Collection;

public interface ReviewRepository extends Repository<Integer, Review> {
    Collection<Review> findByUser(User user) throws NonExistingEntityException;
    Collection<Review> findByMovie(Movie movie) throws NonExistingEntityException;
    Collection<Review> findByDate(LocalDate date) throws NonExistingEntityException;
}
