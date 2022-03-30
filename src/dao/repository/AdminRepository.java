package dao.repository;

import dao.exception.NonExistingEntityException;
import model.entity.*;

import java.util.Collection;

public interface AdminRepository extends UserRepository{
     Collection<Admin> findAdminByModeratedMovie( Movie movie) throws NonExistingEntityException;
     Collection<Admin> findAdminByModeratedUser(User user) throws NonExistingEntityException;
     Collection<Admin> findAdminByModeratedTicket(Ticket ticket) throws NonExistingEntityException;
     Collection<Admin> findAdminByModeratedDailyProgram(DailyProgram dailyProgram) throws NonExistingEntityException;
     Collection<Admin> findAdminByModeratedProjection(Projection projection) throws NonExistingEntityException;
     Collection<Admin> findAdminByModeratedHall(Hall hall) throws NonExistingEntityException;
    Collection<Admin> findAdminByModeratedReview(Review review) throws NonExistingEntityException;


}
