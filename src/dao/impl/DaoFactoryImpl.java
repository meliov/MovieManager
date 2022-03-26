package dao.impl;

import dao.DaoFactory;
import dao.repository.*;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserRepository createUserRepository() {
        return new UserRepositoryImpl(new UserRepository.LongIdGenerator());
    }

    @Override
    public MovieRepository createMovieRepository() {
        return new MovieRepositoryImpl(new MovieRepository.LongIdGenerator());
    }

    @Override
    public ReviewRepository createReviewRepository() {
        return new ReviewRepositoryImpl(new ReviewRepository.LongIdGenerator());
    }

    @Override
    public ProgramRepository createProgramRepository() {
        return new ProgramRepositoryImpl(new Repository.LongIdGenerator());
    }

}
