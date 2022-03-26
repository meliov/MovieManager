package dao;

import dao.repository.MovieRepository;
import dao.repository.ProgramRepository;
import dao.repository.ReviewRepository;
import dao.repository.UserRepository;

public interface DaoFactory {
    UserRepository createUserRepository();
    MovieRepository createMovieRepository();
    ReviewRepository createReviewRepository();
    ProgramRepository createProgramRepository();
}
