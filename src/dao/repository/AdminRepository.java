package dao.repository;

import dao.exception.NonExistingEntityException;
import model.entity.Admin;
import model.entity.Movie;
import model.entity.User;

import java.util.Collection;

public interface AdminRepository extends UserRepository{
    Collection<Admin> findAdminByModeratedMovie(Movie movie) throws NonExistingEntityException;
    Collection<Admin> findAdminByModeratedUser(User user) throws NonExistingEntityException;
}
