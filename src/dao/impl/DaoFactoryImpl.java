package dao.impl;

import dao.DaoFactory;
import dao.IntegerIdGenerator;
import dao.repository.*;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserRepository createUserRepository(String fileName) {
        return new UserRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

    @Override
    public MovieRepository createMovieRepository(String fileName) {
        return new MovieRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

    @Override
    public ReviewRepository createReviewRepository(String fileName) {
        return new ReviewRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

    @Override
    public ProgramRepository createProgramRepository(String fileName) {
        return new ProgramRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

    @Override
    public ProjectionRepository createProjectionRepository(String fileName) {
        return new ProjectionRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

    @Override
    public HallRepository createHallRepository(String fileName) {
        return new HallRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

    @Override
    public TicketRepository createTicketRepository(String fileName) {
        return new TicketRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

    @Override
    public AdminRepository createAdminRepository(String fileName) {
        return new AdminRepositoryImpls(new IntegerIdGenerator(), fileName);
    }

    @Override
    public RegisteredUserRepository createRegisteredUserRepository(String fileName) {
        return new RegisteredUseRepositoryImpl(new IntegerIdGenerator(), fileName);
    }

}
