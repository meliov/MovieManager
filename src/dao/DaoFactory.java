package dao;

import dao.repository.*;

public interface DaoFactory {
    UserRepository createUserRepository();
    MovieRepository createMovieRepository();
    ReviewRepository createReviewRepository();
    ProgramRepository createProgramRepository();
    ProjectionRepository createProjectionRepository();
    HallRepository createHallRepository();
    TicketRepository createTicketRepository();
    AdminRepository createAdminRepository();
    RegisteredUserRepository createRegisteredUserRepository();
}
