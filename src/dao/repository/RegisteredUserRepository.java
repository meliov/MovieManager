package dao.repository;

import dao.exception.NonExistingEntityException;
import model.entity.Movie;
import model.entity.RegisteredUser;
import model.entity.Ticket;

import java.util.Collection;

public interface RegisteredUserRepository extends UserRepository{
    Collection<RegisteredUser> findUsersByWatchedMovie(Movie movie) throws NonExistingEntityException;
    Collection<RegisteredUser> findUsersByFavouriteMovie(Movie movie) throws NonExistingEntityException;
    Collection<RegisteredUser> findUsersByOrderedTicket(Ticket ticket) throws NonExistingEntityException;
}
