package dao;

import dao.repository.*;

public interface DaoFactory {
    UserRepository createUserRepository(String fileName);
    MovieRepository createMovieRepository(String fileName);
    ReviewRepository createReviewRepository(String fileNam);
    ProgramRepository createProgramRepository(String fileName);
    ProjectionRepository createProjectionRepository(String fileName);
    HallRepository createHallRepository(String fileName);
    TicketRepository createTicketRepository(String fileName);
    AdminRepository createAdminRepository(String fileName);
    RegisteredUserRepository createRegisteredUserRepository(String fileName);
}
