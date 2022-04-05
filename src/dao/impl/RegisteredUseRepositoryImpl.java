package dao.impl;

import dao.IdGenerator;
import dao.exception.NonExistingEntityException;
import dao.repository.RegisteredUserRepository;
import model.entity.*;

import java.util.Collection;
import java.util.stream.Collectors;

class RegisteredUseRepositoryImpl extends UserRepositoryImpl implements RegisteredUserRepository {
    public RegisteredUseRepositoryImpl(IdGenerator<Integer> idGenerator, String fileName) {
        super(idGenerator, fileName);
    }

    @Override
    public Collection<RegisteredUser> findUsersByWatchedMovie(Movie movie) throws NonExistingEntityException {
        load();
        var users =  entityMap.values()
                .stream()
                .filter(e -> e instanceof RegisteredUser)
                .map(RegisteredUser.class::cast)
                .filter(e ->  {
//                    System.out.println(e);
                    return e.getWatchedMovies().contains(movie);
                })
                .collect(Collectors.toList());
        if (users.isEmpty()){
            System.out.println(users.size());
            throw new NonExistingEntityException(movie.getMovieName() +" is not watched by any user. User not found. Movie id = " + movie.getId());
        }
        return users;
    }

    @Override
    public Collection<RegisteredUser> findUsersByFavouriteMovie(Movie movie) throws NonExistingEntityException {
        load();
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

}
