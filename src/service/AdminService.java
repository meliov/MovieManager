package service;

import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.repository.UserRepository;
import model.entity.*;

public interface AdminService  {
//    DailyProgram addToProgram()
    DailyProgram addDailyProgram(Admin admin,DailyProgram dailyProgram);
    DailyProgram deleteDailyProgram(Admin admin,DailyProgram dailyProgram);
    DailyProgram updateDailyProgram(Admin admin,DailyProgram dailyProgram);
    User updateUser(Admin admin, User registeredUser) throws InvalidEntityDataException, NonExistingEntityException;
    User addUser(Admin admin, User registeredUser) throws InvalidEntityDataException, EntityAlreadyExistsException;
    User deleteUser(Admin admin, User registeredUser) throws NonExistingEntityException;
    Hall addHall(Admin admin,Hall hall);
    Hall deleteHall(Admin admin,Hall hall);
    Hall updateHall(Admin admin,Hall hall);
    Ticket addTicket(Admin admin,Ticket ticket);
    Ticket updateTicket(Admin admin,Ticket ticket);
    Ticket deleteTicket(Admin admin,Ticket ticket);
    Projection addProjection(Admin admin,Projection projection);
    Projection deleteProjection(Admin admin,Projection projection);
    Projection updateProjection(Admin admin,Projection projection);
    Review updateReview(Admin admin,Review review);
    Review deleteReview(Admin admin,Review review);
    Review addReview(Admin admin,Review review);
    Movie addMovie(Admin admin,Movie movie) throws EntityAlreadyExistsException;
    Movie updateMovie(Admin admin,Movie movie) throws NonExistingEntityException;
    Movie deleteMovie(Admin admin,Movie movie);
}
