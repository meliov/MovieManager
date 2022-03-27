package dao.impl;

import dao.DaoFactory;
import dao.repository.*;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserRepository createUserRepository() {
        return new UserRepositoryImpl(new Repository.IntegerIdGenerator());
    }

    @Override
    public MovieRepository createMovieRepository() {
        return new MovieRepositoryImpl(new Repository.IntegerIdGenerator());
    }

    @Override
    public ReviewRepository createReviewRepository() {
        return new ReviewRepositoryImpl(new Repository.IntegerIdGenerator());
    }

    @Override
    public ProgramRepository createProgramRepository() {
        return new ProgramRepositoryImpl(new Repository.IntegerIdGenerator());
    }

}
