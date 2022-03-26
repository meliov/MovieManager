package dao.impl;

import dao.DaoFactory;
import dao.repository.MovieRepository;
import dao.repository.UserRepository;
import dao.repository.Repository;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserRepository createUserRepository() {
        return new UserRepositoryImpl(new UserRepository.LongIdGenerator());
    }

    @Override
    public MovieRepository createMovieRepository() {
        return new MovieRepositoryImpl(new MovieRepository.LongIdGenerator());
    }

}
