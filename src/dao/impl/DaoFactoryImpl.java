package dao.impl;

import dao.DaoFactory;
import dao.repository.*;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserRepository createUserRepository() {
        return new UserRepositoryImpl(new UserRepository.IntegerIdGenerator());
    }

    @Override
    public MovieRepository createMovieRepository() {
        return new MovieRepositoryImpl(new MovieRepository.IntegerIdGenerator());
    }

    @Override
    public ReviewRepository createReviewRepository() {
        return new ReviewRepositoryImpl(new ReviewRepository.IntegerIdGenerator());
    }

    @Override
    public ProgramRepository createProgramRepository() {
        return new ProgramRepositoryImpl(new ProgramRepository.IntegerIdGenerator());
    }

    @Override
    public ProjectionRepository createProjectionRepository() {
        return new ProjectionRepositoryImpl(new Repository.IntegerIdGenerator());
    }

}
