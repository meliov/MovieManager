package dao;

import dao.repository.MovieRepository;
import dao.repository.UserRepository;

public interface DaoFactory {
    UserRepository createUserRepository();
    MovieRepository createMovieRepository();
}
