package dao.impl;

import dao.exception.NonExistingEntityException;
import dao.repository.RegisteredUserRepository;
import model.entity.*;

import java.util.Collection;
import java.util.stream.Collectors;

class RegisteredUseRepositoryImpl extends UserRepositoryImpl implements RegisteredUserRepository {
    public RegisteredUseRepositoryImpl(IdGenerator<Integer> idGenerator) {
        super(idGenerator);
    }

    @Override
    public Collection<RegisteredUser> findUsersByWatchedMovie(Movie movie) throws NonExistingEntityException {
        var users =  entityMap.values()
                .stream()
                .filter(e -> e instanceof RegisteredUser)
                .map(RegisteredUser.class::cast)
                .filter(e ->  e.getWatchedMovies().contains(movie))
                .collect(Collectors.toList());
        if (users.isEmpty()){
            throw new NonExistingEntityException(movie.getMovieName() +" is not watched by any user. User not found.");
        }
        return users;
    }

    @Override
    public Collection<RegisteredUser> findUsersByFavouriteMovie(Movie movie) throws NonExistingEntityException {
        var users =  entityMap.values()
                .stream()
                .filter(e -> e instanceof RegisteredUser)
                .map(RegisteredUser.class::cast)
                .filter(e ->  e.getFavouriteMovies().contains(movie))
                .collect(Collectors.toList());
        if (users.isEmpty()){
            throw new NonExistingEntityException(movie.getMovieName() +" is not in favourites of any user. User not found.");
        }
        return users;
    }

    @Override
    public Collection<RegisteredUser> findUsersByOrderedTicket(Ticket ticket) throws NonExistingEntityException {
        var users =  entityMap.values()
                .stream()
                .filter(e -> e instanceof RegisteredUser)
                .map(RegisteredUser.class::cast)
                .filter(e ->  e.getOrderedTickets().contains(ticket))
                .collect(Collectors.toList());
        if (users.isEmpty()){
            throw new NonExistingEntityException(ticket +" is not ordered by any user. User not found.");
        }
        return users;
    }

    @Override
    public Collection<RegisteredUser> finUsersByReview(Review review) throws NonExistingEntityException {
        var users =  entityMap.values()
                .stream()
                .filter(e -> e instanceof RegisteredUser)
                .map(RegisteredUser.class::cast)
                .filter(e ->  e.getReviews().contains(review))
                .collect(Collectors.toList());
        if (users.isEmpty()){
            throw new NonExistingEntityException("Review about "+review.getMovie().getMovieName() +" is not left by any user. User not found.");
        }
        return users;
    }
}
